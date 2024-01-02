package ua.samoplavskaya.HW_hibernate;

import jakarta.persistence.*;
import org.hibernate.query.hql.spi.SemanticPathPart;

import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUnit");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        //task1(entityManager);

        // User user = task2(entityManager, 5);
        entityManager.getTransaction().commit();
        entityManager.close();
//        System.out.println("List of orders for user " + user.getFirstname() + " " + user.getLastname() + ": ");
//        System.out.println(user.getOrders());
        try (EntityManager entityManager1 = emf.createEntityManager()) {
            entityManager1.getTransaction().begin();
            task3(entityManager1);
        }
        emf.close();
    }


    public static void task1(EntityManager entityManager) {

        User user = User.builder()
                .firstname("Iryna").
                lastname("Samoplavskaya").
                email("samoplavskayaI@gmail.com").
                build();
        entityManager.persist(user);

        User user1 = entityManager.find(User.class, 6L);
        System.out.println(user1);

        user1.setLastname("Petrecova");
        System.out.println(user1);

        User user2 = entityManager.find(User.class, 7L);
        entityManager.remove(user2);
        entityManager.getTransaction().commit();
    }

    public static User task2(EntityManager entityManager, int id) {
        User user = entityManager.find(User.class, id);
        Order order1 = Order.builder()
                .product("iPhone 11")
                .amount(54000)
                .build();
        Order order2 = Order.builder()
                .product("iPhone 12")
                .amount(50000)
                .build();
        entityManager.persist(order1);
        entityManager.persist(order2);
        user.addOrder(order1);
        user.addOrder(order2);
        return user;
    }

    public static void task3(EntityManager entityManager) {
        TypedQuery<User> query1 = entityManager.createQuery("SELECT u FROM User u WHERE size(u.orders)>5", User.class);
        List<User> resultList = query1.getResultList();
        System.out.println("All users who have more than 5 orders:\n" + resultList);
//            List<Order> selectOrder = entityManager1.createQuery("SELECT o FROM Order o", Order.class).getResultList();
//            int minusDays = 0;
//            for (Order order : selectOrder) {
//                order.setDate(LocalDateTime.now().minusDays(minusDays));
//                minusDays++;
//            }
        List<Order> resultList1 = entityManager.createQuery("SELECT o FROM Order o WHERE o.user.id= :userID AND o.date BETWEEN :startDate AND :endDate", Order.class)
                .setParameter("userID", 6)
                .setParameter("startDate", LocalDateTime.now().minusDays(10))
                .setParameter("endDate", LocalDateTime.now())
                .getResultList();
        System.out.println("All orders made by user 6 in the last 10 days:\n" + resultList1);

        List<Object[]> results = entityManager.createQuery("SELECT u.firstname,u.lastname, COUNT(o.id) FROM User u JOIN u.orders o GROUP BY u.id", Object[].class)
                .getResultList();

        for (Object[] result : results) {
            System.out.println("User: " + result[0] + " " + result[1] + ", Total Orders: " + result[2]);
        }

        entityManager.getTransaction().commit();
    }

}


