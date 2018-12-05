package app.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import app.dao.ConnectToDB;
import org.bson.Document;

public class RetrievingDocument extends ConnectToDB{

	public FindIterable<Document> getTableDataDoc(String tableName) {

		// Retrieving a collection
		MongoCollection<Document> collection = this.database.getCollection(tableName);
		System.out.println("Collection sampleCollection selected successfully");

		// Getting the iterable object
		FindIterable<Document> iterableDoc = collection.find();
		return iterableDoc;
	}
	
	public FindIterable<Document> getRowFromTableDoc(String tableName, BasicDBObject query) {
		// Retrieving a collection
		MongoCollection<Document> collection = this.database.getCollection(tableName);
		System.out.println("Collection sampleCollection selected successfully");

		// Getting the iterable object
		
		FindIterable<Document> iterableDoc = collection.find(query);
		return iterableDoc;
	}
}
