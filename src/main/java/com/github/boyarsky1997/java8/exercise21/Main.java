package com.github.boyarsky1997.java8.exercise21;

import com.github.boyarsky1997.java8.model.Director;
import com.github.boyarsky1997.java8.model.Genre;
import com.github.boyarsky1997.java8.model.Movie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Find the number of genres of each director's movies:
 */
public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie(1, "Hary Potter", 1998, "zak");
        Movie movie2 = new Movie(2, "Terminator", 1989, "zak");
        Movie movie3 = new Movie(3, "Rembo", 2000, "zak");

        Director director1 = new Director(1, "Roman", "zak");
        Director director2 = new Director(2, "Vitalik", "zak");

        Genre fantasy = new Genre(1, "Fantasy");
        Genre thriller = new Genre(2, "Thriller");

        director2.setMovies(Arrays.asList(movie2, movie3));
        director1.setMovies(Collections.singletonList(movie1));

        movie1.setGenres(Collections.singletonList(fantasy));
        movie2.setGenres(Arrays.asList(fantasy, thriller));
        movie3.setGenres(Collections.singletonList(thriller));

        movie1.setDirectors(Collections.singletonList(director1));
        movie2.setDirectors(Collections.singletonList(director2));
        movie3.setDirectors(Arrays.asList(director1, director2));

        List<Director> directors = Arrays.asList(director1, director2);

        Map<String, Integer> collect = directors.stream()
                .flatMap(director -> director.getMovies()
                        .stream()
                        .flatMap(movie -> movie.getGenres()
                                .stream()
                                .map(genre -> new AbstractMap.SimpleEntry<>(director.getName(), genre)
                                )))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,
                        Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toSet()))).entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, b -> b.getValue().size()));


        System.out.println(collect);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = integers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduce);

    }
}
