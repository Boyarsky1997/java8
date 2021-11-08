package com.github.boyarsky1997.java8.exercise17;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Задано набір прізвищ співробітників. Розробити програму, яка показує всі прізвища що починаються на букву 'R'
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> al = new ArrayList<String>();

        System.out.println("Enter names: ");
        while (true) {
            System.out.print("name = ");
            s = scanner.nextLine();
            if (s.equals(""))
                break;
            al.add(s);
        }
        System.out.println();

        System.out.println("AL = " + al);

        long count = al.stream()
                .filter(a -> Character.toUpperCase(a.charAt(0)) == 'R')
                .count();
        System.out.println(count);
    }
}
