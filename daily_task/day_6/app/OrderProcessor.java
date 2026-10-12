package app;

import exception.InsufficientStockException;
import exception.InvalidQuantityException;

import java.util.Scanner;

public class OrderProcessor {

    private static int availableStock = 10;

    public static void processOrder(int quantity)
            throws InsufficientStockException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero."
            );
        }

        if (quantity > availableStock) {
            throw new InsufficientStockException(
                    "Insufficient stock! Available stock: " + availableStock
            );
        }

        availableStock -= quantity;

        System.out.println("Order placed successfully!");
        System.out.println("Quantity ordered: " + quantity);
        System.out.println("Remaining stock: " + availableStock);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ORDER PROCESSOR =====");
            System.out.println("1. Place order");
            System.out.println("2. View stock");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter quantity: ");

                        try {
                            int quantity =
                                    Integer.parseInt(scanner.nextLine());

                            processOrder(quantity);

                        } catch (InvalidQuantityException
                                | InsufficientStockException e) {

                            System.out.println("Order failed: " + e.getMessage());

                        } finally {
                            System.out.println("Audit: Order attempt completed.");
                        }
                        break;

                    case 2:
                        System.out.println(
                                "Available stock: " + availableStock
                        );
                        break;

                    case 3:
                        System.out.println("Exiting Order Processor.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid menu choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input! Please enter a valid number."
                );

            } catch (Exception e) {
                // Preserve the original exception as the cause.
                RuntimeException wrappedException =
                        new RuntimeException("Unexpected order processing error", e);

                System.out.println(wrappedException.getMessage());
                System.out.println(
                        "Original cause: " +
                        wrappedException.getCause().getMessage()
                );
            }
        }
    }
}