package app.dao;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class ConnectToDB {
	private MongoCredential credential;
	private MongoClient mongo;
	
	public void openConnection() {
		// Creating a Mongo client
		this.mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		this.credential = MongoCredential.createCredential("", "mydatabase", "".toCharArray());
		System.out.println("Connected to the database successfully");
	}
	
	
	public MongoDatabase getAccessDatabase() {
		// Accessing the database
		MongoDatabase database = this.mongo.getDatabase("mydatabase");
		System.out.println("Credentials ::" + this.credential);
		return database;
	}
	
	public MongoCredential getCredential() {
		return credential;
	}


	public void setCredential(MongoCredential credential) {
		this.credential = credential;
	}


	public MongoClient getMongo() {
		return mongo;
	}


	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	}
	
	

}