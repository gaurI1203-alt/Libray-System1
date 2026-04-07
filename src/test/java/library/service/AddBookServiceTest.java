package library.service;

import library.model.Book;
import library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBookServiceTest {

    AddBookService service;

    @BeforeEach
    void setUp() {
        service = new AddBookService();

        // IMPORTANT: clear repository before each test
        BookRepository.getAllBooks().clear();
    }

    @Test
    void testAddBookSuccessfully() {
        service.addBook(1, "Java", "James", 5);

        Book book = BookRepository.findBookById(1);

        assertNotNull(book);
        assertEquals("Java", book.getTitle());
        assertEquals("James", book.getAuthor());
        assertEquals(5, book.getTotalCopies());
    }

    @Test
    void testAddDuplicateBook() {
        service.addBook(1, "Java", "James", 5);
        service.addBook(1, "Java", "James", 5);

        // Should still only have 1 book
        int size = BookRepository.getAllBooks().size();

        assertEquals(1, size);
    }

    @Test
    void testDisplayBooksWhenEmpty() {
        assertTrue(BookRepository.getAllBooks().isEmpty());
        service.displayBooks();
    }

    @Test
    void testDisplayBooksWithData() {
        service.addBook(2, "Spring", "Rod", 3);

        assertFalse(BookRepository.getAllBooks().isEmpty());
        service.displayBooks();
    }
}