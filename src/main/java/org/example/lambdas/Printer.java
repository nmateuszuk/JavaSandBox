package org.example.lambdas;

public interface Printer {

    //as long as we have single abstract method it doesnt matter how many default and static methods --->
    // it is still functional interface
    void print(String message);

    //as per newest java editions may have here default implementation but it contradicts interface idea
//    default void printTwice(String message){
//        System.out.println(message);
//        System.out.println(message);
//    }

}
