package ua.samoplavskaya.hw_employees;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\hw_employees\\input.txt");
        try {
            List<Employees> employees = readFromFile(file);
            File file1 = new File("D:\\A-Level\\Home work\\HomeWork\\src\\ua\\samoplavskaya\\hw_employees\\output.txt");
            file1.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
            bufferedWriter.write("1.Full name of any employee whose firstName starts with ‘A’:\n");

            List<String> fullName = printFullNameIfFirstNameStartsOnLetter(employees, "A");
            for (String s : fullName) {
                bufferedWriter.write(s + "\n");
            }

            sortOnFirstNameAndSalary(employees);
            bufferedWriter.write("\n2.Sort employees based on firstName, for same firstName sort by salary:\n");
            for (Employees employee : employees) {
                bufferedWriter.write("name : \"" + employee.getFirstName() + "\"\n");
                bufferedWriter.write("secondName : \"" + employee.getSecondName() + "\"\n");
                bufferedWriter.write("salary : " + employee.getSalary() + "\n");
                bufferedWriter.write("age : " + employee.getAge() + "\n\n");
            }

            bufferedWriter.write("\n3.Print list of all employee with min salary:\n");
            for (Employees employee1 : printEmployeesWithMinSalary(employees)) {
                bufferedWriter.write("name : \"" + employee1.getFirstName() + "\"\n");
                bufferedWriter.write("secondName : \"" + employee1.getSecondName() + "\"\n");
                bufferedWriter.write("salary : " + employee1.getSalary() + "\n");
                bufferedWriter.write("age : " + employee1.getAge() + "\n\n");
            }

            bufferedWriter.write("\n4.Total salary: " + totalSalary(employees) + "\n");
            bufferedWriter.write("\n5.The difference in salary between the youngest and the oldest employee: " + differenceInSalary(employees) + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static List<Employees> readFromFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Employees> employees = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("name")) {
                String name = line.split(":")[1].replaceAll("\"", "").trim();
                String secondName = bufferedReader.readLine().split(":")[1].replaceAll("\"", "").trim();
                int salary = Integer.parseInt(bufferedReader.readLine().split(":")[1].trim());
                int age = Integer.parseInt(bufferedReader.readLine().split(":")[1].trim());
                Employees employee = new Employees(name, secondName, salary, age);
                employees.add(employee);
            }
        }

        return employees;
    }

    private static List<String> printFullNameIfFirstNameStartsOnLetter(List<Employees> employees, String letter) {
        return employees.stream()
                .filter(employee -> employee.getFirstName().startsWith(letter))
                .map(employee -> employee.getFirstName() + " " + employee.getSecondName())
                .toList();
    }

    private static void sortOnFirstNameAndSalary(List<Employees> employees) {
        Comparator<Employees> firstNameComparator = (Comparator.comparing(Employees::getFirstName));
        Comparator<Employees> salaryComparator = (Comparator.comparingInt(Employees::getSalary));
        firstNameComparator.thenComparing(salaryComparator);
        employees.sort(firstNameComparator);
    }

    private static List<Employees> printEmployeesWithMinSalary(List<Employees> employees) {
        int minSalary = employees.stream()
                .min(Comparator.comparingInt(Employees::getSalary))
                .get()
                .getSalary();
        return employees.stream()
                .filter(employee -> (employee.getSalary() == minSalary))
                .collect(Collectors.toList());
    }

    private static int totalSalary(List<Employees> employees) {
        return employees.stream()
                .mapToInt(Employees::getSalary)
                .sum();
    }

    private static int differenceInSalary(List<Employees> employees) {
        Comparator<Employees> comparatorForMin = Comparator
                .comparingInt(Employees::getAge)
                .thenComparing(Comparator.comparing(Employees::getSalary).reversed());
        Comparator<Employees> comparatorForMax = Comparator
                .comparingInt(Employees::getAge)
                .thenComparing(Employees::getSalary);

        Employees yong = employees.stream()
                .min(comparatorForMin)
                .get();
        Employees oldest = employees.stream()
                .max(comparatorForMax)
                .get();

        return Math.abs(yong.getSalary() - oldest.getSalary());
    }

}


