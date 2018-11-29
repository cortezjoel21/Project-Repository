package app.dao;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import app.dao.ConnectToDB;
import app.dto.UserDto;


public class InsertingDocument extends ConnectToDB{
	
	private MongoCollection<Document> collection;
	
	public void addUser(UserDto userDto) {
		MongoCollection<Document> mongoCollection = this.database.getCollection("user");
		this.collection = mongoCollection;
		System.out.println("Collection sampleCollection selected successfully");
		
		/**
		 * access: admin, access type 0
		 *	access: user, access type 1
		 */
		System.out.println("===userDto.getId(): " + userDto.getId().intValue());
		System.out.println("===userDto.getAccessTypeNo(): " + userDto.getUsername());
		System.out.println("===userDto.getAccessTypeNo(): " + userDto.getPassword());
		System.out.println("===userDto.getAccessTypeNo(): " + userDto.getEmail());
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
//		id.addUser();
//	}
}
