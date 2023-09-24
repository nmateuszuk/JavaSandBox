package org.example.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionFilterLambda {

    public static boolean czyParzysta(int liczba) {
        if (liczba % 2 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {

        List<Integer> lista = IntStream.range(1, 100).boxed().toList();
        System.out.println(lista);

        List<Integer> parzyste = new ArrayList<>();
        for (int element : lista) {
            if (element % 2 == 0) {
                parzyste.add(element);
            }
        }
        System.out.println(parzyste);

        //using function reference
        List<Integer> parzysteV2 = lista.stream().filter(CollectionFilterLambda::czyParzysta).toList();
        System.out.println(parzysteV2);

        //using lambda
        List<Integer> parzysteV3 = lista.stream().filter(liczba -> czyParzysta(liczba)).toList();
        System.out.println(parzysteV3);

        List<Integer> parzysteV4 = lista.stream().filter(liczba -> liczba % 2 == 0).toList();
        System.out.println(parzysteV4);

        List<Integer> parzysteV5 = lista.parallelStream().filter(liczba -> {
            if (liczba % 2 == 0)
                return true;
            return false;
        }).toList();

        System.out.println(parzysteV5);


    }
}
