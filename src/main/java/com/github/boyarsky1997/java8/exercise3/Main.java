package com.github.boyarsky1997.java8.exercise3;

import com.github.boyarsky1997.java8.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Obtain a list of product with category = “Toys” and then apply 10% discount
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product((long) 1, "Book1", "Toys", 85.6),
                new Product((long) 5, "Magazine1", "Toys", 255.0),
                new Product((long) 2, "Book3", "Toys", 101.0),
                new Product((long) 2, "Book2", "books", 95.5),
                new Product((long) 6, "Magazine2", "magazine", 99.0),
                new Product((long) 2, "Book4", "Toys", 255.0));

        List<Product> toys = products.stream()
                .filter(x -> x.getCategory().equals("Toys"))
                .peek(z -> z.setPrice((z.getPrice() / 100) * 90))
                .collect(Collectors.toList());

        System.out.println(toys);
    }
}
