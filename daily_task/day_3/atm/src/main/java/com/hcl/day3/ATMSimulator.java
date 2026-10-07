package com.hcl.day3;

import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int CORRECT_PIN = 1234;
        int balance = 10000;
        boolean loggedIn = false;

        String[] transactions = new String[10];
        int transactionCount = 0;

        // =========================
        // PIN VALIDATION
        // =========================

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Enter PIN: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next();
                attempt--;
                continue;
            }

            int pin = scanner.nextInt();

            if (pin == CORRECT_PIN) {
                System.out.println("PIN correct!");
                loggedIn = true;
                break;
            } else {
                System.out.println("Incorrect PIN.");

                if (attempt < 3) {
                    System.out.println(
                            "Attempts remaining: " + (3 - attempt)
                    );
                }
            }
        }

        // =========================
        // BLOCK ATM
        // =========================

        if (!loggedIn) {
            System.out.println("ATM BLOCKED!");
            scanner.close();
            return;
        }

        // =========================
        // ATM MENU
        // =========================

        atmMenu:
        do {

            System.out.println();
            System.out.println("========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            // Handle non-numeric menu input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                // =========================
                // CHECK BALANCE
                // =========================

                case 1:

                    System.out.println(
                            "Current Balance: ₹" + balance
                    );

                    break;

                // =========================
                // DEPOSIT
                // =========================

                case 2:

                    System.out.print("Enter deposit amount: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println(
                                "Invalid input. Please enter a number."
                        );
                        scanner.next();
                        continue;
                    }

                    int deposit = scanner.nextInt();

                    if (deposit <= 0) {
                        System.out.println("Invalid deposit amount.");
                        continue;
                    }

                    balance = balance + deposit;

                    if (transactionCount < transactions.length) {
                        transactions[transactionCount] =
                                "Deposit: +" + deposit;
                        transactionCount++;
                    }

                    System.out.println(
                            "₹" + deposit + " deposited successfully."
                    );

                    System.out.println(
                            "Current Balance: ₹" + balance
                    );

                    break;

                // =========================
                // WITHDRAW
                // =========================

                case 3:

                    System.out.print("Enter withdrawal amount: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println(
                                "Invalid input. Please enter a number."
                        );
                        scanner.next();
                        continue;
                    }

                    int withdrawal = scanner.nextInt();

                    if (withdrawal <= 0) {
                        System.out.println(
                                "Invalid withdrawal amount."
                        );
                        continue;
                    }

                    if (withdrawal > balance) {
                        System.out.println(
                                "Insufficient balance."
                        );
                        continue;
                    }

                    balance = balance - withdrawal;

                    if (transactionCount < transactions.length) {
                        transactions[transactionCount] =
                                "Withdraw: -" + withdrawal;
                        transactionCount++;
                    }

                    System.out.println(
                            "Please collect your cash."
                    );

                    System.out.println(
                            "Current Balance: ₹" + balance
                    );

                    break;

                // =========================
                // MINI STATEMENT
                // =========================

                case 4:

                    System.out.println();
                    System.out.println("===== MINI STATEMENT =====");

                    if (transactionCount == 0) {
                        System.out.println("No transactions yet.");
                    } else {

                        for (int i = 0; i < transactionCount; i++) {
                            System.out.println(
                                    transactions[i]
                            );
                        }
                    }

                    // Enhanced for demonstration
                    System.out.println();
                    System.out.println("Transaction Summary:");

                    for (String transaction : transactions) {

                        if (transaction == null) {
                            continue;
                        }

                        System.out.println(transaction);
                    }

                    break;

                // =========================
                // EXIT
                // =========================

                case 5:

                    System.out.println(
                            "Thank you for using our ATM!"
                    );

                    break atmMenu;

                // =========================
                // INVALID CHOICE
                // =========================

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );

                    continue;
            }

        } while (true);

        scanner.close();
    }
}