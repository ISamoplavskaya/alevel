package ua.samoplavskaya.hw_patterns.Strategy;

public class CarRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String destination) {
        System.out.println("Маршрут на машині до " + destination);
    }
}
