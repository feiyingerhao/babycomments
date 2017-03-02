package main.java.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by zhao on 2017/3/2.
 */
public class TMInsert {
    public void TMInsertNewAppname(String databasename,String collections,String content) {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://root:becareful@121.40.66.28:27017/admin");
        MongoClient mongoClient = new MongoClient( mongoClientURI);
        MongoDatabase database = mongoClient.getDatabase(databasename);
        MongoCollection<Document> collection = database.getCollection(collections);
        Document document = Document.parse(content);
        collection.insertOne(document);
        mongoClient.close();
    }
}
