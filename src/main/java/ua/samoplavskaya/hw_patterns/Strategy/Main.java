package ua.samoplavskaya.hw_patterns.Strategy;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        navigator.setRouteStrategy(new WalkRouteStrategy());
        navigator.calculateRoute("Lviv");
    }
}
