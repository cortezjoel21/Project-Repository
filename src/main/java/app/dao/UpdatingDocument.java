package app.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import app.dao.ConnectToDB;
import app.dto.UserDto;

import java.util.Iterator;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class UpdatingDocument extends ConnectToDB{

	public void updateUser(UserDto user) {
		// Retrieving a collection
		MongoCollection<Document> collection = this.database.getCollection("user");
		System.out.println("Collection sampleCollection selected successfully");

		collection.updateOne(Filters.eq("id", user.getId().intValue()), Updates.set("accessType", user.getAccessType()));
		collection.updateOne(Filters.eq("id", user.getId().intValue()), Updates.set("accessTypeNo", user.getAccessTypeNo()));
		System.out.println("Document update successfully...");

		// Retrieving the documents after updation
		// Getting the iterable object
		BasicDBObject query = new BasicDBObject();
		query.put("id", user.getId().intValue());
		FindIterable<Document> iterDoc = collection.find(query);
		int i = 1;

		// Getting the iterator
		Iterator it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			i++;
		}
	}
}