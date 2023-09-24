package org.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 15, Genre.THRILLER),
                new Movie("c", 20, Genre.ACTION)
        );

        int count = 0;
        //imperative programing
        for (var movie : movies) {
            if (movie.getLikes() > 10)
                count++;
        }

        //declarative (functional) programing
        var count2 = movies.stream().
                filter(movie -> movie.getLikes() > 10).
                count();
        System.out.println(count2);

        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
        //movies.stream().filter(movie -> movie.getLikes() > 10).forEach(movie -> System.out.println(movie.getTitle()));
        movies.stream().filter(isPopular).forEach(movie -> System.out.println(movie.getTitle()));

        //creating streams
        int[] numbers = {1, 2, 3, 4};
        Arrays.stream(numbers).forEach(n -> System.out.println(n));

        var stream2 = Stream.of(1, 2, 3, 4);
        var stream = Stream.generate(() -> Math.random()); //lazy loading
        stream.limit(3).forEach(n -> System.out.println(n));


        Stream.iterate(1, n -> n + 1).limit(10).forEach(n -> System.out.println(n));

        ///mapping elements
        movies.stream().map(movie -> movie.getTitle()).forEach(name -> System.out.println(name));
        movies.stream().mapToInt(movie -> movie.getLikes()).forEach(like -> System.out.println(like));

        //////


        //flat map
        var stream3 = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        //stream3.forEach(list -> System.out.println(list)); //it will print two lists
        stream3.flatMap(list -> list.stream()).forEach(n -> System.out.println(n));

        //slicing streams
        movies.stream().limit(2).forEach(movie -> System.out.println(movie.getTitle()));

        //1000movies, 10 movies per page, 3rd page, skip(20)= skip ((page-1)xpageSize), limit(10) limit(pageSize)

        movies.stream().skip(20).limit(10).forEach(movie -> System.out.println(movie.getTitle()));

        movies.stream().takeWhile(movie -> movie.getLikes() < 30).forEach(movie -> System.out.println(movie.getTitle()));

        //sorting streams

        movies.stream()
                //.sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))  -->to samo
                //.sorted(Comparator.comparing(movie -> movie.getTitle())) -->to samo
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(movie -> System.out.println(movie.getTitle()));

        //getting uniqe elements
        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);

        //peeking elements
        movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .peek(movie -> System.out.println("filtered:" + movie.getTitle()))
                .map(movie -> movie.getTitle())
                .peek(title -> System.out.println("mapped " + title))
                .forEach(System.out::println);

        //simple reducers

        var result = movies.stream()
                //find any/ max/min/count
                //max(Comparator.comparing(....
                .findFirst()
                .get();
        System.out.println(result.getTitle());

        //reducing a stream
        Optional<Integer> sum = movies.stream()
                .map(movie -> movie.getLikes())//[10,20,30]
                //.reduce(Integer::sum)
                .reduce((a, b) -> a + b);

        System.out.println(sum.orElse(0));

        ///collectors
        var result2 = movies.stream().filter(movie -> movie.getLikes() > 10).collect(Collectors.toList());
        System.out.println(result2);

        var resultMap = movies.stream().filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getLikes, Movie::getTitle));
        System.out.println(resultMap);

        //to store movie like object
        var resultMap2 = movies.stream().filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getLikes, Function.identity()));
        System.out.println(resultMap2);

        var result3 = movies.stream().filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        var result5 = movies.stream().filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println(result5);

        var result6 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));

        //group
        var results7 = movies.stream().collect(Collectors.
                groupingBy(Movie::getGenre, Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));
        //var results7 = movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
        //var results7 = movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet()));
        System.out.println(results7);

        var result8 = movies.stream().collect(Collectors.partitioningBy(movie -> movie.getLikes() > 20));
        var result9 = movies.stream().collect(Collectors.
                partitioningBy(movie -> movie.getLikes() > 20, Collectors.mapping(Movie::getTitle, Collectors.joining(","))));

        //primitive type streams
        IntStream.range(1, 5).forEach(System.out::println);
    }

    public static void main(String[] args) {
        show();
    }

}
