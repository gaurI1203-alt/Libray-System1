package library.service;

import library.service.IssueBookService;  // ✅ ADD THIS
import library.model.Book;
import library.repository.BookRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IssueBookServiceTest {

    @Test
    void testBookIssuedSuccessfully() {
        Book book = new Book(1, "Java", "Author", 5);
        BookRepository.addBook(book);

        boolean result = IssueBookService.issueBook(1);

        assertTrue(result);
        assertEquals(4, book.getAvailableCopies());
    }

    @Test
    void testBookNotFound() {
        boolean result = IssueBookService.issueBook(999);
        assertFalse(result);
    }

    @Test
    void testNoCopiesAvailable() {
        Book book = new Book(2, "Python", "Author", 0);
        BookRepository.addBook(book);

        boolean result = IssueBookService.issueBook(2);

        assertFalse(result);
    }
}