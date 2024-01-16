package ua.samoplavskaya.hw_dao.service;

import ua.samoplavskaya.hw_dao.dao.Dao;
import ua.samoplavskaya.hw_dao.dao.impl.HibernateDao;
import ua.samoplavskaya.hw_dao.dao.impl.JDBCDao;
import ua.samoplavskaya.hw_dao.entity.Person;

import java.util.List;


public class PersonService {
    private final Dao<Person> personDao = JDBCDao.getInstance();

    public PersonService() {
    }

    public Person findPersonByID(long id) {
        return personDao.findByID(id)
                .orElseThrow(() -> new RuntimeException("Person with " + id + " not found"));
    }

    public List<Person> findAllPerson() {
        return personDao.findAll();
    }

    public void savePerson(Person person) {
        personDao.save(person);
    }

    public void updatePerson(Person person) {
        personDao.update(person);
    }

    public void deletePerson(Person person) {
        personDao.delete((person));
    }
}
