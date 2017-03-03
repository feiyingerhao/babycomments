package main.java.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by haolidong on 2017/3/3.
 */
public class AmazonInsert {
    public void InsertNewAppname(String databasename,String collections,Document document) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase(databasename);
        MongoCollection<Document> collection = database.getCollection(collections);
        collection.insertOne(document);
        mongoClient.close();
    }
}
