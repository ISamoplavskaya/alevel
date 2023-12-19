package ua.samoplavskaya.lesson11;

public class Circle implements Comparable<Circle> {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return 2*Math.PI*radius;
    }

    @Override
    public int compareTo(Circle o) {
        return (int)(getArea()-o.getArea());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Circle{");
        sb.append("radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}
