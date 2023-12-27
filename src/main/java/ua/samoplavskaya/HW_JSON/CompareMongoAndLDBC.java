package ua.samoplavskaya.HW_JSON;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.bson.Document;
import org.bson.types.ObjectId;


public class CompareMongoAndLDBC {
    public static void main(String[] args) {
        //crudJDBC();
        crudMongo();
    }

    private static void crudJDBC() {
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyUnit")) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Person person = Person.builder()
                    .firstname("Vasyl")
                    .lastname("Korbut")
                    .email("VKorbut@gmail.com")
                    .build();
            entityManager.persist(person);

            Person person1 = entityManager.find(Person.class, 1L);
            System.out.println(person1);

            person1.setFirstname("Olena");
            System.out.println(person1);

            entityManager.remove(entityManager.find(Person.class, 4L));
            entityManager.getTransaction().commit();
        }
    }

    private static void crudMongo() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://admin:admin123@localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("persons");
            Document person = new Document("firstname", "Lena")
                    .append("secondname", "Pavluk")
                    .append("email", "LPavluk@gmail.com");
            collection.insertOne(person);

            collection.find(Filters.eq("firstname", "Lena")).forEach(System.out::println);

            collection.updateOne(Filters.eq("_id", new ObjectId("658c178162617248828faa75")), Updates.set("firstname", "Lev"));

            collection.deleteMany(Filters.eq("firstname", "Lena"));

        }
    }
}
