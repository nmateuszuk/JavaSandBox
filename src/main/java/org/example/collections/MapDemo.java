package org.example.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show(){
        List<Customer> customers= new ArrayList<>();

//        //not scalable O(n) end of list -> O(lenght of list) increases lineary
//        for (var customer : customers){
//            if(customer.getEmail()== "e1")
//                System.out.println("Found!");}

        var c1= new Customer("a", "e1");
        var c2= new Customer("b", "e2");
        Map<String, Customer> map= new HashMap<>();

        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(),c2);




        }
    }

