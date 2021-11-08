package com.github.boyarsky1997.java8.exercise5;

import com.github.boyarsky1997.java8.model.Product;

import java.util.*;

/***
 * Get the cheapest products of “Books” category
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product((long) 1, "Book1", "Books", 85.6),
                new Product((long) 5, "Magazine1", "magazine", 255.0),
                new Product((long) 2, "Book3", "Books", 101.0),
                new Product((long) 2, "Book2", "Books", 95.5),
                new Product((long) 6, "Magazine2", "magazine", 99.0),
                new Product((long) 2, "Book4", "Books", 255.0));

        Product books = products.stream()
                .filter(x -> x.getCategory().equals("Books"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);

        System.out.println(books.getPrice());

    }
}
