package ua.samoplavskaya.hw9;

public class Triangle extends Figure {
    private String nameFigure;
    private double sideA;
    private double sideB;
    private double sideC;
    private int degree;
    private double height;



    public Triangle(String nameFigure) {
        super(nameFigure);
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public int getDegree() {
        return degree;
    }

    public double getHeight() {
        return height;
    }


    @Override
    public double perimeter() {
        if (sideA!=0&&sideB!=0&&sideC!=0) {
            return (sideA + sideB + sideC);
        } else if (sideA!=0&&sideB!=0&&degree!=0) {
            return (sideA+sideB+Math.sqrt(sideA*sideA+sideB*sideB-2*sideA*sideB*Math.cos(degree*Math.PI/180)));
        } else {System.out.println("There is not enough data to calculate the perimeter of a triangle");
            return 0;}

    }

    @Override
    public double area() {
        if (sideA!=0&&sideB!=0&&sideC!=0) {
            return areaOfTriangle(sideA, sideB, sideC);
        } else if (sideA!=0&&sideB!=0&&degree!=0) {
            return areaOfTriangle(sideA,sideB,degree);
        } else if (sideA!=0&&height!=0) {
            return areaOfTriangle(sideA,height);
        } else {System.out.println("There is not enough data to calculate the area of a triangle");
            return 0;}
    }


    public double areaOfTriangle(double sideA, double sideB, double sideC) {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double areaOfTriangle(double sideA, double sideB, int degree) {
        return sideA * sideB * Math.sin(degree*Math.PI/180) / 2;
    }

    public double areaOfTriangle(double sideA, double height){
        return sideA*height/2;
    }

}
