package org.example.lambdas;

public class LambdasDemo {

    public LambdasDemo(String message){
    }

    public void print(String message){}

    public static String prefix2= "--";
    public static void show(){
     //   greet(new ConsolePrinter());

    /////////////////////passing lambda expresion as an argument
        String prefix= "-";



//                greet((String message)->{
//            System.out.println(message);
//        });

        //make it tider
        greet(message-> System.out.println(message));
        greet(message-> System.out.println(prefix + message));
        greet(message-> System.out.println(LambdasDemo.prefix2 + message));

        //Class/Object::method -->method reference
        greet(System.out::println);



////////////////////////

        ///start lambda expresion in a variable
        Printer printer= message -> System.out.println(message);

        //////////////////////
        //method reference to static method in this class, signature of this method matches the
        // print method of printer interface
        //greet(message -> print(message));
        // greet(LambdasDemo::print);

//        var demo=new LambdasDemo();
//        greet(demo::print);
//        greet(message -> demo.print(message));

        //passing value to a constructor
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);
        ////////




        //anonymous inner class--> anonymous because this class doesnt have a name
        greet(new Printer() {
            @Override
            public void print(String message) {
             System.out.println(message);
            }
        });
    }

    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
