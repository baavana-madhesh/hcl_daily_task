package service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import java.util.Queue;

import model.Book;

public class LibraryService {

    // FR1: Store books in an ArrayList.
    private List<Book> catalogue = new ArrayList<>();

    // FR2: Store unique members in insertion order.
    private Set<String> members = new LinkedHashSet<>();

    // FR3: Manage the waitlist in FIFO order.
    private Queue<String> waitlist = new ArrayDeque<>();

    public void addBook(Book book) {
        catalogue.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        System.out.println("\n--- Book Catalogue ---");

        for (Book book : catalogue) {
            System.out.println(book);
        }
    }

    public void registerMember(String name) {
        if (members.add(name)) {
            System.out.println(name + " registered successfully!");
        } else {
            System.out.println(name + " is already registered!");
        }
    }

    public void addToWaitlist(String name) {
        if (!members.contains(name)) {
            System.out.println("Please register the member first.");
            return;
        }

        waitlist.offer(name);
        System.out.println(name + " added to waitlist.");
    }

    public void processNextMember() {
        String next = waitlist.poll();

        if (next == null) {
            System.out.println("Waitlist is empty.");
        } else {
            System.out.println("Next member: " + next);
        }
    }

    public void displayMembers() {
        System.out.println("\n--- Registered Members ---");
        for (String member : members) {
            System.out.println(member);
        }
    }

    public void displayWaitlist() {
        System.out.println("\n--- Waitlist ---");
        for (String member : waitlist) {
            System.out.println(member);
        }
    }
}