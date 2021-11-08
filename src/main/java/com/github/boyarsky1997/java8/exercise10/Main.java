package com.github.boyarsky1997.java8.exercise10;

import com.github.boyarsky1997.java8.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Obtain a collection of statistical figures (i.e. sum, average, max, min, count) for all products of category “Books”
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product((long) 1, "Book1", "books", 85.6),
                new Product((long) 5, "Magazine1", "magazine", 255.0),
                new Product((long) 2, "Book3", "books", 101.0),
                new Product((long) 2, "Book2", "books", 95.5),
                new Product((long) 6, "Magazine2", "magazine", 99.0),
                new Product((long) 2, "Book4", "magazine", 255.0));

        List<Double> books = products.stream()
                .filter(product -> product.getCategory().equals("books"))
                .map(Product::getPrice)
                .collect(Collectors.toList());

        Double min = books.stream()
                .min(Double::compareTo)
                .get();

        Double max = books.stream()
                .max(Double::compareTo)
                .get();

        Double sum = books.stream()
                .mapToDouble(Double::byteValue)
                .sum();

        double average = books.stream()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.format("average = %s, sum = %s, max = %s, min = %s", average, sum, max, min);

    }
}
