package com.github.boyarsky1997.java8.exercise1;

import com.github.boyarsky1997.java8.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Obtain a list of products belongs to category “Books” with price > 100
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

        List<Product> books = products.stream()
                .filter(x -> x.getCategory().equals("books"))
                .filter(x -> x.getPrice() > 100)
                .collect(Collectors.toList());

        books.forEach(System.out::println);

    }
}
