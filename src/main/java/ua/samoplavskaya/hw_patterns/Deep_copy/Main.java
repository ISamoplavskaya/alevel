package ua.samoplavskaya.hw_patterns.Deep_copy;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = Address.builder()
                .city("Kyiv")
                .street("Sergeenko")
                .building("6g")
                .build();
        Person originPerson = Person.builder()
                .firstname("Alex")
                .lastname("Katrenko")
                .age(36)
                .address(address)
                .build();
        Person clonePerson = (Person) originPerson.clone();

        originPerson.setFirstname("Oleg");
        System.out.println(originPerson);
        System.out.println(clonePerson);

    }
}
