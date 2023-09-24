package org.example.collections;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void show(){
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add(0,"!");
        list.set(0,"a+");
        System.out.println(list);

    }
}
