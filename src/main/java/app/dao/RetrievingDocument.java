package app.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import app.ManageUserApplication;
import app.dao.ConnectToDB;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.bson.Document;

public class RetrievingDocument {

	public FindIterable<Document> getTableDataDoc(String tableName) {

		// Open Database Connection
		ConnectToDB ctdb = new ConnectToDB();
		ctdb.openConnection();
		MongoDatabase database = ctdb.getAccessDatabase();

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection(tableName);
		System.out.println("Collection sampleCollection selected successfully");

		// Getting the iterable object
		FindIterable<Document> iterableDoc = collection.find();
		return iterableDoc;
	}
	
	public FindIterable<Document> getRowFromTableDoc(String tableName, BasicDBObject query) {

		// Open Database Connection
		ConnectToDB ctdb = new ConnectToDB();
		ctdb.openConnection();
		MongoDatabase database = ctdb.getAccessDatabase();

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection(tableName);
		System.out.println("Collection sampleCollection selected successfully");

		// Getting the iterable object
		
		FindIterable<Document> iterableDoc = collection.find(query);
		return iterableDoc;
	}
	
//
//	public static void main(String[] args) {
//		RetrievingDocument rad = new RetrievingDocument();
//		
//		for (Document doc : rad.getTableDataDoc("user")) {
//			System.out.println("======doc: " + doc.getInteger("id"));
//			System.out.println("======doc: " + doc.getString("username"));
//			System.out.println("======doc: " + doc.getString("email"));
//		}
//	}
}
