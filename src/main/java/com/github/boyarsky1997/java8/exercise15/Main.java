package com.github.boyarsky1997.java8.exercise15;

import com.github.boyarsky1997.java8.Product;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Get the most expensive product by category
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product((long) 1, "Book1", "books", 85.6),
                new Product((long) 5, "Magazine1", "magazine", 255.0),
                new Product((long) 2, "Book3", "books", 101.0),
                new Product((long) 2, "Book2", "books", 95.5),
                new Product((long) 6, "Magazine2", "magazine", 99.0),
                new Product((long) 2, "Book4", "books", 152.0));

        Map<String, Optional<Product>> collect = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        System.out.println(collect);
    }
}