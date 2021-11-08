package com.github.boyarsky1997.java8.exercise7;

import com.github.boyarsky1997.java8.model.Customer;
import com.github.boyarsky1997.java8.model.Order;
import com.github.boyarsky1997.java8.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get a list of orders which were ordered on 15-Mar-2021,
 * log the order records to the console and then return its product list
 */
public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, LocalDate.of(2021, 3, 15), LocalDate.now(), "SEND",
                        new Customer(1, "Vasya", 2)),
                new Order(2, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Kolya", 1)),
                new Order(3, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Roma", 1)),
                new Order(4, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Vitalik", 1)),
                new Order(5, LocalDate.now().minusDays(3), LocalDate.now(), "SEND",
                        new Customer(1, "Slavik", 2)),
                new Order(6, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Taras", 1)));

        Set<Product> products = new HashSet<>();
        products.add(new Product((long) 5, "Book1", "Baby", 85.6));
        products.add(new Product((long) 6, "Book1", "books", 85.6));
        products.add(new Product((long) 7, "Book1", "books", 85.6));
        products.add(new Product((long) 8, "Book1", "books", 85.6));
        orders.get(0).setProducts(products);

        List<Product> collect1 = orders.stream()
                .filter(a -> a.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .flatMap(order -> order.getProducts()
                        .stream())
                .collect(Collectors.toList());
    }
}
