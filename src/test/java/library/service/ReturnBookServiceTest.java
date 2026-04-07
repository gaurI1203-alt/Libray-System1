package library.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import library.model.Book;
import library.repository.BookRepository;

public class ReturnBookServiceTest {

    // ✅ 1. Success case
    @Test
    public void testReturnBookSuccess() {

        BookRepository.clearAllBooks();

        Book book = new Book(1, "Java", "Author", 5, 3);
        BookRepository.addBook(book);

        ReturnBookService service = new ReturnBookService();
        service.returnBook(1);

        Book updatedBook = BookRepository.findBookById(1);

        assertEquals(4, updatedBook.getAvailableCopies());
    }

    // ✅ 2. Book not found
    @Test
    public void testReturnBookNotFound() {

        BookRepository.clearAllBooks();

        ReturnBookService service = new ReturnBookService();
        service.returnBook(99);

        // No exception = pass
        assertTrue(true);
    }

    // ✅ 3. Already full (no change)
    @Test
    public void testReturnBookAlreadyFull() {

        BookRepository.clearAllBooks();

        Book book = new Book(1, "Java", "Author", 5, 5);
        BookRepository.addBook(book);

        ReturnBookService service = new ReturnBookService();
        service.returnBook(1);

        Book updatedBook = BookRepository.findBookById(1);

        assertEquals(5, updatedBook.getAvailableCopies());
    }

    // ✅ 4. Multiple returns
    @Test
    public void testMultipleReturns() {

        BookRepository.clearAllBooks();

        Book book = new Book(1, "Java", "Author", 5, 2);
        BookRepository.addBook(book);

        ReturnBookService service = new ReturnBookService();

        service.returnBook(1);
        service.returnBook(1);

        Book updatedBook = BookRepository.findBookById(1);

        assertEquals(4, updatedBook.getAvailableCopies());
    }

    // ✅ 5. Boundary case (only 1 copy left to fill)
    @Test
    public void testReturnBookBoundary() {

        BookRepository.clearAllBooks();

        Book book = new Book(1, "Java", "Author", 5, 4);
        BookRepository.addBook(book);

        ReturnBookService service = new ReturnBookService();
        service.returnBook(1);

        Book updatedBook = BookRepository.findBookById(1);

        assertEquals(5, updatedBook.getAvailableCopies());
    }
}