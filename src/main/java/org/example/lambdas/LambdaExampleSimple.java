package org.example.lambdas;

public class LambdaExampleSimple {
    public boolean validatePassword(String password) {
        //special characters length numbers
        if (password.length() > 15 && password.matches(".*[0-9].*") && (!password.matches("[a-zA-Z0-9]*")))
        {
            System.out.println(password);
            return true;
        }
        return false;
        }

    public static void main(String[] args) {
        LambdaExampleSimple lambda= new LambdaExampleSimple();
        lambda.validatePassword("Cat1!2222222222222fff");
    }
}