package ua.samoplavskaya.hw_employees;

public class Employees {
    private String firstName;
    private String secondName;

    private int salary;
    private int age;

    public Employees(String name, String secondName, int salary, int age) {
        this.firstName = name;
        this.secondName = secondName;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employees{");
        sb.append("first name='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
