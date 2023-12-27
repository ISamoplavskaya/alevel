package ua.samoplavskaya.HW_JSON;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;


public class MongoTask {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://admin:admin123@localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("orders");
            Document doc = new Document("product", "Iphone 11")
                    .append("price", 15000)
                    .append("quntity", 3);
            collection.insertOne(doc);

            FindIterable<Document> documents = collection.find(Filters.gt("price", 30000));
            try (MongoCursor<Document> cursor = documents.cursor()) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            Bson iphone15 = Filters.eq("product", "Iphone 15");
            System.out.println("Document before updating:");
            collection.find(iphone15).forEach(System.out::println);
            Bson updates = Updates.combine(Updates.set("quntity", 1), Updates.inc("price", 500));
            collection.updateMany(iphone15, updates);
            System.out.println("Document after updating:");
            collection.find(iphone15).forEach(System.out::println);


            DeleteResult deleteResult = collection.deleteMany(Filters.lt("price", 40000));
            System.out.println("Documents deleted: " + deleteResult.getDeletedCount());


        }

    }
}
