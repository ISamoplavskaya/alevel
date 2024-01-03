package ua.samoplavskaya.hw_dao.dao;

import ua.samoplavskaya.hw_dao.entity.Person;
import ua.samoplavskaya.hw_dao.service.PersonService;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PersonService service = new PersonService();

        Person person1 = Person.builder()
                .firstname("Oleg")
                .lastname("SHevchuk")
                .email("oShevchuk@gmail.com")
                .build();
        service.savePerson(person1);

        Person personByID = service.findPersonByID(1L);
        System.out.println(personByID);

        personByID.setFirstname("NewName");
        service.updatePerson(personByID);

        List<Person> allPerson = service.findAllPerson();
        allPerson.forEach(System.out::println);

        service.deletePerson(service.findPersonByID(7L));


    }
}
