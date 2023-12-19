package ua.samoplavskaya.hw7;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Создайте класс, который описывает вектор (в трёхмерном пространстве).
//У него должны быть:
//а) конструктор с параметрами в виде списка координат x, y, z
//б) метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
//в) метод, вычисляющий векторное произведение с другим вектором
//г) метод, вычисляющий косинус угла между векторами: косинус угла между векторами
//равен скалярному произведению векторов, деленному на произведение модулей (длин)
//векторов;
//д) методы для суммы и разности векторов
//е) статический метод, который принимает целое число n, и возвращает массив случайных
//векторов размером n.
//*Если метод возвращает вектор, то он должен возвращать новый объект, а не менять
//базовый
public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector() {
    }

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double lenghtVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector vectorProduct(Vector vectorB) {
        Vector resultVector = new Vector();
        resultVector.x = y * vectorB.z - z * vectorB.y;
        resultVector.y = z * vectorB.x - x * vectorB.z;
        resultVector.z = x * vectorB.y - y * vectorB.x;
        return resultVector;
    }

    public int scalarProduct(Vector vectorB) {
        return x * vectorB.x + y * vectorB.y + z * vectorB.z;
    }

    public double cosOfAngleBetweenVectors(Vector vectorB) {
        return scalarProduct(vectorB) / (lenghtVector() * vectorB.lenghtVector());
    }

    public Vector sumVectors(Vector vectorB) {
        return new Vector(x + vectorB.x, y + vectorB.y, z + vectorB.z);
    }

    public Vector difVectors(Vector vectorB) {
        return new Vector(x - vectorB.x, y - vectorB.y, z - vectorB.z);
    }

    public static Vector[] arrayOfRandomVectors(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(ThreadLocalRandom.current().nextInt(-100, 100),
                    ThreadLocalRandom.current().nextInt(-100, 100),
                    ThreadLocalRandom.current().nextInt(-100, 100));
        }
        return vectors;
    }

    public static void main(String[] args) {
        Vector[] vectors = arrayOfRandomVectors(5);
        System.out.println(Arrays.toString(vectors));
        System.out.println("Vector A: " + vectors[0]);
        System.out.println("Vector B: " + vectors[1]);
        System.out.println("The length of the vector A: " + vectors[0].lenghtVector());
        System.out.println("Vector product of Vector A and Vector B: " + vectors[0].vectorProduct(vectors[1]));
        System.out.println("The cosine of the angle between Vector A and Vector B: " + vectors[0].cosOfAngleBetweenVectors(vectors[1]));
        System.out.println("Vector sum: " + vectors[0].sumVectors(vectors[1]));
        System.out.println("Vector difference: " + vectors[0].difVectors(vectors[1]));

    }

}
