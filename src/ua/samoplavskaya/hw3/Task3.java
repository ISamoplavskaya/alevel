package ua.samoplavskaya.hw3;

import java.util.Scanner;

//Программа "Угадай число"
//Задача
//Отгадать целое число, которое "загадал" компьютер в определенном диапазоне.
//
//Решение
//Описание переменных:
//
//a – число, "загаданное" компьютером;
//b – очередное число, вводимое пользователем.
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game \"Guess the number\"");
        System.out.println("guess from (enter a number): ");
        int min = scanner.nextInt();
        System.out.println("to (enter a number): ");
        int max = scanner.nextInt();
        int a = (int) (min + Math.random() * max);
        // System.out.println(number);
        game(a);
    }

    public static void game(int a) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Guess the number:");
            int b = scanner.nextInt();
            if (b == a) {
                System.out.println("You win!!!");
                break;
            } else if (b > a) {
                System.out.println("Wrong, your number is greater.");
            } else System.out.println("Wrong, your number is less.");
        }
    }
}

