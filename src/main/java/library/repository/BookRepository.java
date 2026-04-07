package library.repository;

import java.util.ArrayList;
import java.util.List;
import library.model.Book;

public class BookRepository {

    private static List<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        if (findBookById(book.getId()) == null) {
            books.add(book);
        } else {
            System.out.println("Book with this ID already exists");
        }
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public static Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public static void deleteBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
        }
    }

    // ✅ useful for tests
    public static void clearAllBooks() {
        books.clear();
    }
}