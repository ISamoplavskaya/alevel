package ua.samoplavskaya.lesson17;

import java.util.Arrays;

public class TestEnum {
    public static void main(String[] args) {
        for (DayOfTheWeek day : DayOfTheWeek.values()) {
            System.out.print(day+" ");
            System.out.println(day.getNumber());
        }
    }
}
