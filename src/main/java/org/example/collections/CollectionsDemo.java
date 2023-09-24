package org.example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show(){
        Collection<String> collection= new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        System.out.println(collection);
        Collections.addAll(collection, "d","e");
        for (var item: collection){
            System.out.println(item);
        }
        System.out.println(collection.size());
        collection.remove("c");
//        collection.clear(); //remove all items
//        collection.isEmpty();

        collection.contains("a");

//        var objectArray= collection.toArray();
//        var stringArray= collection.toArray(new String[5]);
//        var stringArray= collection.toArray(new String[0]); --> when 0 no worries about size

        Collection<String> other= new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection==other); // false bo inne obiekty
        System.out.println(collection.equals(other)); // true bo ten sam content



    }
}
