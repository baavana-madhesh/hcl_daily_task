package app;

import model.Book;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {

        LibraryService library = new LibraryService();

        // FR1: Book catalogue
        library.addBook(new Book(1, "Java Basics", "James"));
        library.addBook(new Book(2, "SQL Guide", "Robert"));
        library.displayBooks();

        // FR2: Member registration
        library.registerMember("Arun");
        library.registerMember("Priya");
        library.registerMember("Arun");
        library.displayMembers();

        // FR3: Waitlist
        library.addToWaitlist("Arun");
        library.addToWaitlist("Priya");
        library.displayWaitlist();

        library.processNextMember();
        library.displayWaitlist();
    }
}