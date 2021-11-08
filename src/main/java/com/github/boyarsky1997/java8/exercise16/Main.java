package com.github.boyarsky1997.java8.exercise16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  Для будь-якого набору випадково згенерованих чисел потрібно визначити кількість парних
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int number;
        Random rnd = new Random();

        for (int i=0; i<10; i++) {
            number = rnd.nextInt() % 100;
            al.add(number);
        }

        System.out.println("Array AL:");
        System.out.println(al);

        int integerStream = (int) al.stream().filter(a -> a % 2 == 0).count();
        System.out.println(integerStream);

    }
}
