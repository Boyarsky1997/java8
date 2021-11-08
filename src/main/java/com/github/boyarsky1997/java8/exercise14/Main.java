package com.github.boyarsky1997.java8.exercise14;

import com.github.boyarsky1997.java8.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Obtain a data map with list of product name by category
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product((long) 1, "Book1", "books", 85.6),
                new Product((long) 5, "Magazine1", "magazine", 255.0),
                new Product((long) 2, "Book3", "books", 101.0),
                new Product((long) 2, "Book2", "books", 95.5),
                new Product((long) 6, "Magazine2", "magazine", 99.0),
                new Product((long) 2, "Book4", "books", 255.0));

        Map<String, List<String>> collect = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));
        System.out.println(collect);
    }
}
