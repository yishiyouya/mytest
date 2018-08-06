package mongoTest;



import org.bson.Document;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.async.MongoConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MyMongoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMongoDB("collection");
	}

	public static void findMongoDB(String collection) {
		MongoCollection<Document> collection2 = getMongoDB(collection);
		FindIterable<Document> findIterable = collection2.find();  
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
           System.out.println(mongoCursor.next());  
        } 
	}
	
	public static MongoCollection<Document> getMongoDB(String collection) {
		MongoClient moClient = new MongoClient("127.0.0.1", 27017);
		MongoDatabase moDataBase = moClient.getDatabase("test");
		MongoCollection<Document> collection2 = moDataBase.getCollection(collection);
		return collection2;
	}
}
