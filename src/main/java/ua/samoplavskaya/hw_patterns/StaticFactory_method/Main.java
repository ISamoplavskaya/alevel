package ua.samoplavskaya.hw_patterns.StaticFactory_method;

public class Main {
    public static void main(String[] args) {
        Order order1 = Order.of("TV", 36666.99, 6, "info", "Lviv");
        Order order2 = Order.getBasicOrder("Phone", 52360.99, 2);
        System.out.println(order1);
        System.out.println(order2);
    }
}
