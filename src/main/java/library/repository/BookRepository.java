package library.repository;

import java.util.ArrayList;
import java.util.List;
import library.model.Book;

public class BookRepository {

    // Common shared book list (acts like database)
    private static List<Book> books = new ArrayList<>();

    // Add book to storage
    public static void addBook(Book book) {
        books.add(book);
    }

    // Get all books
    public static List<Book> getAllBooks() {
        return books;
    }

    // Find book by ID
    public static Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Delete book (optional, if needed later)
    public static void deleteBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
        }
    }
}