package com.github.boyarsky1997.java8.exercise22;

import com.github.boyarsky1997.java8.model.City;
import com.github.boyarsky1997.java8.model.Country;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *Find the highest populated capital city:
 */
public class Main {
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(new City(1, "Lviv", "3456", 3000),
                new City(2, "Kiev", "3344", 9000));
        Country ukraine = new Country("1", "Ukraine", "Europe", 100000, 345.6, 222, 1234);
        ukraine.setCities(cities);

        List<City> cities1 = Arrays.asList(new City(4, "Madrid", "3456", 23300),
                new City(3, "Barselona", "3344", 3000));
        Country italia = new Country("2", "Italia", "Europe", 3000, 35.6, 32, 134);
        italia.setCities(cities1);

        List<Country> countries = Arrays.asList(ukraine, italia);


        int max = countries.stream()
                .flatMap(country -> country.getCities().stream()).collect(Collectors.toList())
                .stream()
                .mapToInt(City::getPopulation)
                .max().orElseThrow(NoSuchElementException::new);
        System.out.println(max);

    }
}
