package com.github.boyarsky1997.java8.exercise8;

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
 * Calculate total lump sum of all orders placed in Feb 2021
 */
public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, LocalDate.of(2021, 2, 15), LocalDate.now(), "SEND",
                        new Customer(1, "Vasya", 2)),
                new Order(2, LocalDate.of(2021,3,15), LocalDate.now(), "SEND",
                        new Customer(2, "Kolya", 1)),
                new Order(3, LocalDate.of(2021,2,2), LocalDate.now(), "SEND",
                        new Customer(2, "Roma", 1)),
                new Order(4, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Vitalik", 1)),
                new Order(5, LocalDate.now().minusDays(3), LocalDate.now(), "SEND",
                        new Customer(1, "Slavik", 2)),
                new Order(6, LocalDate.now().minusDays(1), LocalDate.now(), "SEND",
                        new Customer(2, "Taras", 1)));

        Set<Product> products = new HashSet<>();
        products.add(new Product((long) 8, "Book1", "books", 35.6));
        orders.get(0).setProducts(products);
        Set<Product> products1 = new HashSet<>();
        products1.add(new Product((long) 5, "Book1", "Baby", 83.6));
        products1.add(new Product((long) 6, "Book1", "books", 5.6));
        orders.get(2).setProducts(products1);
        Set<Product> products2 = new HashSet<>();
        products2.add(new Product((long) 7, "Book1", "books", 22225.6));
        orders.get(1).setProducts(products2);

        List<Order> collect = orders.stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,2,1))>=0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,3,1))<0)
                .collect(Collectors.toList());
        double sum = collect.stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println(sum);
    }
}
