package org.example;

import org.example.collections.CollectionsDemo;
import org.example.collections.Customer;
import org.example.collections.EmailComparator;
import org.example.collections.SetDemo;
import org.example.exceptions.*;
import org.example.generics.*;
import org.example.lambdas.LambdasDemo;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //ExceptionsDemo.show();

        int [] nums = {2,7,11,15};
        int [] nums2 = {3,2,5,4};
        int target2 = 6;
        int target= 9;
        SumRecrutment sum= new SumRecrutment();
        sum.twoSum2(nums2, target);

        var account = new Account();
        account.deposit(1);

        //generics
        var list= new GenericList<Integer>();
        list.add(1);

        //comparable interface
        var user1= new User(10);
        var user2= new User(20);
        if(user1.compareTo(user2)<0)
            System.out.println("user1<user2");
        else if (user1.compareTo(user2)==0)
            System.out.println("user1 == user2");
        else
            System.out.println("user1>user2");

        var max= Utils.max(1,3);
        System.out.println("Comparable max: "+ max);

        var max2 =Utils.max(user1, user2);
        System.out.println("user: "+ max2);

        Utils.print(1,10);

        //generic classes and inheritance
        User user= new Instructor(10);
        Utils.printUser(user);

        var users= new GenericList<User>();
        Utils.printUsers(users);

        var instructors= new GenericList<Instructor>();
        Utils.printUsers(instructors);

        ////////////////////////////////
        ///iterable generic list

        var list2= new GenericList<String>();
        list2.add("a");
        list2.add("b");

//        Iterator<String> iterator= list2.iterator();
//        while (iterator.hasNext()){
//            var current=iterator.next();
//            System.out.println(current);
//        }

        for(String item:list2)
            System.out.println(item);
        /////////////////////////////////

        ///collections
        CollectionsDemo.show();
        ////////////////////////////
        ////comparable

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("a", "e1"));
        customers.add(new Customer("c","e3" ));
        customers.add(new Customer("b", "e4"));
        System.out.println("sortuje:");
        Collections.sort(customers);
        Collections.sort(customers, new EmailComparator());
        System.out.println(customers);

        /////////////////////////////////////

        SetDemo.show();
        LambdasDemo.show();


        try{
        account.withdraw(10);}
        catch (AccountException e){
            System.out.println(e.getMessage());
        }

        //w ten sposob java compiler zajmie sie zamknieciem zasobow
        try(
                var reader = new FileReader("file.txt");
                var writer= new FileReader("...");

        ) {
            var value= reader.read();
            System.out.println("Opened");
        }
        catch (IOException e) {
            System.out.println("Could not read data");
        }


//        FileReader reader= null;
//
//        try {
//            reader = new FileReader("file.txt");
//            var value= reader.read();
//            new SimpleDateFormat().parse("file.txt");
//            System.out.println("Opened");
//            // reader.close(); może się nigdy nie zamknac
//        }
////        catch (FileNotFoundException ex){ //można zostawic jako bardziej specyficzna informacje dla uzytkownika
////            System.out.println("File doesnt exist");
////        }
//        catch (IOException | ParseException e) {    ////// można mieć jedno bo tamta rozszerza IOException
//            System.out.println("Could not read data");
//        }
//        finally {
//            if(reader!= null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                   e.printStackTrace();
//                }
//            }
//        }

        }

}