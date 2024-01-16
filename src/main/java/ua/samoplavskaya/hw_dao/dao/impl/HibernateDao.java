package ua.samoplavskaya.hw_dao.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ua.samoplavskaya.hw_dao.dao.Dao;
import ua.samoplavskaya.hw_dao.entity.Person;
import ua.samoplavskaya.hw_dao.util.HibernateConnectionUtil;

import java.util.List;
import java.util.Optional;

public class HibernateDao implements Dao<Person> {
    private static final HibernateDao INSTANCE = new HibernateDao();

    public HibernateDao() {
    }

    public static HibernateDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<Person> findByID(long id) {
        try (Session session = HibernateConnectionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person == null) {
                System.out.println("Person not found by id " + id);
                transaction.commit();
                return Optional.empty();
            }
            transaction.commit();
            return Optional.of(person);

        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> allPerson;
        try (Session session = HibernateConnectionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryFindAll = "FROM Person";
            allPerson = session.createQuery(queryFindAll, Person.class).getResultList();
            transaction.commit();
        }
        return allPerson;
    }

    @Override
    public void save(Person person) {
        try (Session session = HibernateConnectionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(person);
            transaction.commit();
        }
    }

    @Override
    public void update(Person person) {
        try (Session session = HibernateConnectionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        }
    }

    @Override
    public void delete(Person person) {
        try (Session session = HibernateConnectionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(person);
            transaction.commit();
        }
    }
}
