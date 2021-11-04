package com.github.boyarsky1997.java8;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Run {
    public static void main(String[] args) {
        List<String> product = Arrays.asList("apple", "banan", "eblan", "roman", "baran", "basan", "random");

        Map<Character, List<String>> collect = product.stream().collect(groupingBy(x -> x.charAt(0)));
        Set<Map.Entry<Character, List<String>>> entries = collect.entrySet();
        for (Map.Entry<Character, List<String>> entry : entries) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        product.stream()
                .collect(Collectors.groupingBy(x -> x.charAt(0)))
                .forEach((k,v)-> System.out.printf("%s %s%n",k,v));

    }
}
