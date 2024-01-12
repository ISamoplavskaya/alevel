package ua.samoplavskaya.hw_patterns.Deep_copy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Cloneable {
    private String firstname;
    private String lastname;
    private int age;
    private Address address;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = new Person();
        Address newAddress = new Address(getAddress().getCity(), getAddress().getStreet(), getAddress().getBuilding());
        person.setFirstname(getFirstname());
        person.setLastname(getLastname());
        person.setAge(getAge());
        person.setAddress(newAddress);
        return person;


    }
}
