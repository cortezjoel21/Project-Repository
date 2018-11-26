package app.dao;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import app.dao.ConnectToDB;
import app.dto.UserDto;


public class InsertingDocument {
	
	private MongoCollection<Document> collection;
	public InsertingDocument() {

		// Open Database Connection
		ConnectToDB ctdb = new ConnectToDB();
		ctdb.openConnection();
		MongoDatabase database = ctdb.getAccessDatabase();
		
		// Retrieving a collection
		MongoCollection<Document> mongoCollection = database.getCollection("user");
		this.collection = mongoCollection;
		System.out.println("Collection sampleCollection selected successfully");
	}

//	public void main() {
//		/**
//		 * access: admin, access type 0
//		 *	access: user, access type 1
//		 */
//		Document document = new Document("id", 1)
//				.append("username", "username1")
//				.append("password", "passowrd1")
//				.append("email", "email@yahoo.com")
//				.append("accessType", "Admin")
//				.append("accessTypeNo", "0");
//				
//		this.collection.insertOne(document);
//		System.out.println("Document inserted successfully");
//	}
//	
	
	public void addUser(UserDto userDto) {
		/**
		 * access: admin, access type 0
		 *	access: user, access type 1
		 */
		System.out.println("===userDto.getAccessType(): " + userDto.getAccessType());
		System.out.println("===userDto.getAccessTypeNo(): " + userDto.getAccessTypeNo());
		
		Document document = new Document("id", userDto.getId().intValue())
				.append("username", userDto.getUsername())
				.append("password", userDto.getPassword())
				.append("email", userDto.getEmail())
				.append("accessType", userDto.getAccessType())
				.append("accessTypeNo", userDto.getAccessTypeNo());
				
		this.collection.insertOne(document);
	}
	
//	public static void main(String[] args) {
//		InsertingDocument id = new InsertingDocument();
//		id.main();
//	}
}
