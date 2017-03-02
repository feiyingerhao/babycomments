package main.java.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by haolidong on 2017/3/2.
 */
public class JDInsert {
    public void InsertNewAppname(String databasename,String collections,String content) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase(databasename);
        MongoCollection<Document> collection = database.getCollection(collections);
        Document document = Document.parse(content);
        collection.insertOne(document);
        mongoClient.close();
    }
}
