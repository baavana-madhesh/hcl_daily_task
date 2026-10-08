package app;

import model.BankAccount;
import service.BankService;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 =
                new BankAccount("A101", "Baavana", 5000);

        BankAccount account2 =
                new BankAccount("A102", "Arun", 3000);

        BankService service = new BankService();

        System.out.println("Before transfer:");
        System.out.println("Baavana: " + account1.getBalance());
        System.out.println("Arun: " + account2.getBalance());

        service.transfer(account1, account2, 1000);

        System.out.println("\nAfter transfer:");
        System.out.println("Baavana: " + account1.getBalance());
        System.out.println("Arun: " + account2.getBalance());

        System.out.println("\nTotal accounts: "
                + BankAccount.getAccountCount());
    }
}