package com.github.boyarsky1997.java8.exercise13;

import com.github.boyarsky1997.java8.Customer;
import com.github.boyarsky1997.java8.Order;
import com.github.boyarsky1997.java8.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  Produce a data map with order record and product total sum
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

                Map<Integer, Double> collect = orders.stream()
                        .collect(Collectors.toMap(Order::getId, s -> s.getProducts()
                                .stream()
                                .mapToDouble(Product::getPrice)
                                .sum()));
                System.out.println(collect);
            }

        }

