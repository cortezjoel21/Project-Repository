package app.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import app.dao.ConnectToDB;

import java.util.Iterator;
import org.bson.Document;

public class DeletingDocument extends ConnectToDB{

	public void deleteUser(Integer userId) {

		// Retrieving a collection
		MongoCollection<Document> collection = this.database.getCollection("user");
		System.out.println("Collection sampleCollection selected successfully");

		// Deleting the documents
		collection.deleteOne(Filters.eq("id", userId));
		System.out.println("Document deleted successfully...");

		// Retrieving the documents after updation
		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println("Inserted Document: " + i);
			System.out.println(it.next());
			i++;
		}
	}
	

//	public static void main(String[] args) {
//		DeletingDocument dd = new DeletingDocument();
//		dd.main();
//	}
}
