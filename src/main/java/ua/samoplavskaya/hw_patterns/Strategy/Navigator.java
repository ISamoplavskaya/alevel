package ua.samoplavskaya.hw_patterns.Strategy;

public class Navigator {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void calculateRoute(String destination) {
        routeStrategy.calculateRoute(destination);
    }
}
