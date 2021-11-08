package com.github.boyarsky1997.java8.exercise20;

import com.github.boyarsky1997.java8.model.City;
import com.github.boyarsky1997.java8.model.Country;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Find the most populated city of each continent:
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

        Map<String, Optional<City>> collect1 = countries.stream()
                .flatMap(o -> o.getCities()
                        .stream()
                        .map(city -> new AbstractMap.SimpleEntry<>(o.getContinent(), city)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(
                                Map.Entry::getValue,
                                Collectors.maxBy(Comparator.comparing(City::getPopulation)))));

        collect1.forEach((k, v) -> System.out.println(k +" " + v));
    }
}
