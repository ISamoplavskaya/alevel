package ua.samoplavskaya.hw_patterns.Strategy;

public class WalkRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String destination) {
        System.out.println("Маршрут пішки до " + destination);
    }
}
