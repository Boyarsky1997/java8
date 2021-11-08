package com.github.boyarsky1997.java8.exercise6;

import com.github.boyarsky1997.java8.model.Customer;
import com.github.boyarsky1997.java8.model.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Get the 3 most recent placed order
 */
public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, LocalDate.now().minusDays(3), LocalDate.now(), "SEND",
                        new Customer(1, "VASYA", 2)),
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

        List<Order> collect = orders.stream()
                .skip(orders.size() - 3)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
