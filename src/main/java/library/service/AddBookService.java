package library.service;

import library.model.Book;
import library.repository.BookRepository;

public class AddBookService {

    // Method to add a book
    public void addBook(int id, String title, String author, int totalCopies) {

        // Check if book already exists
        Book existingBook = BookRepository.findBookById(id);
        if (existingBook != null) {
            System.out.println("❌ Book with this ID already exists!");
            return;
        }

        // Create new book object
        Book book = new Book(id, title, author, totalCopies);

        // Store in repository
        BookRepository.addBook(book);

        System.out.println("✅ Book added successfully!");
    }

    // Method to display all books
    public void displayBooks() {

        if (BookRepository.getAllBooks().isEmpty()) {
            System.out.println("📚 No books available.");
            return;
        }

        System.out.println("\n📚 Book List:");
        for (Book book : BookRepository.getAllBooks()) {
            System.out.println(book);
        }
    }
}