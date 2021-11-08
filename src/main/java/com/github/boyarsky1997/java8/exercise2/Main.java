package com.github.boyarsky1997.java8.exercise2;

import com.github.boyarsky1997.java8.model.Customer;
import com.github.boyarsky1997.java8.model.Order;
import com.github.boyarsky1997.java8.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/***
 * Obtain a list of order with products belong to category “Baby
 */
public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, LocalDate.now().minusDays(3), LocalDate.now(), "SEND",
                        new Customer(1, "VASYA", 2)),
                new Order(2, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Kolya", 2)));
        Set<Product> p = new HashSet<>();
        p.add(new Product((long) 1, "Book1", "Baby", 85.6));
        orders.get(0).setProducts(p);
        Set<Product> a = new HashSet<>();
        a.add(new Product((long) 5, "Book1", "Baby", 85.6));
        a.add(new Product((long) 6, "Book1", "books", 85.6));
        a.add(new Product((long) 7, "Book1", "books", 85.6));
        a.add(new Product((long) 8, "Book1", "books", 85.6));
        orders.get(1).setProducts(a);


        List<Order> baby = orders.stream()
                .filter(z -> z.getProducts()
                        .stream()
                        .anyMatch(x -> x.getCategory().equals("Baby")))
                .collect(Collectors.toList());
        baby.forEach(System.out::println);
    }
}
