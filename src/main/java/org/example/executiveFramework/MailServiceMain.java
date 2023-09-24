package org.example.executiveFramework;

public class MailServiceMain {

    public static void main(String[] args) {
        var service = new MailService();
        service.sendAsync();
        System.out.println("Hello ");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

