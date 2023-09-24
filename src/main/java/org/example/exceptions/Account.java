package org.example.exceptions;

public class Account {
    private float balance;
    public void deposit(float value){
        if (value<=0)
            throw  new IllegalArgumentException();
    }
//have to be handled by caller
//    public void deposit2(float value) throws IIOException {
//        if (value<=0)
//            throw  new IIOException();
//    }


//    public void withdraw(float value) throws InsufficientFundsException {
//        if(value>balance)
//            throw new InsufficientFundsException();
//    }

    //throws different type of exception, chaining exceptions
    public void withdraw(float value) throws AccountException {
        if(value>balance)
            throw new AccountException(new InsufficientFundsException());
    }


}
