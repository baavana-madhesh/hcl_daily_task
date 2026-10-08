package service;

import model.BankAccount;

public class BankService {

    public void transfer(BankAccount from, BankAccount to, double amount) {

        if (amount > 0 && amount <= from.getBalance()) {
            from.withdraw(amount);
            to.deposit(amount);
        }
    }
}