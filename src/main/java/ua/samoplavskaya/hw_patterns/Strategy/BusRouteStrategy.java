package ua.samoplavskaya.hw_patterns.Strategy;

public class BusRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String destination) {
        System.out.println("Маршрут на автобусі до " + destination);
    }
}
