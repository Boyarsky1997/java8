package com.github.boyarsky1997.java8.exercise18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задано масив рядків. Використовуючи засоби Stream API посортувати рядки в лексикографічному порядку.
 */
public class Main {
    public static void main(String[] args) {
        String[] as = {
                "abcd", "bcfk", "def", "jklmn", "jprst",
                "afc", "ambn", "kmk", "rbd", "jus"
        };

        List<String> sorted = Arrays.stream(as)
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .collect(Collectors.toList());
        System.out.println(sorted);
    }
}
