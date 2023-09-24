package org.example.exceptions;
//checked-> exception--> this situatio should be thought of
//unchecked (runtime)-> runtimeexception
public class InsufficientFundsException extends Exception {

public InsufficientFundsException(){
    super("insufficient funds in your account.");
}
    public InsufficientFundsException(String message){
        super(message);
    }
}
