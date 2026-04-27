package library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import library.model.Book;
import library.repository.BookRepository;

public class SearchBookServiceTest {

    private SearchBookService service;

    @BeforeEach
    void setup() {
        BookRepository.clearBooks();
        service = new SearchBookService();
    }

    @Test
    void testSearchBookById_Found() {
        Book book = new Book(1, "Java Basics", "Gauri", 5);
        BookRepository.addBook(book);

        Book result = service.searchBookById(1);

        assertNotNull(result);
        assertEquals("Java Basics", result.getTitle());
        assertEquals("Gauri", result.getAuthor());
    }

    @Test
    void testSearchBookById_NotFound() {
        Book result = service.searchBookById(999);

        assertNull(result);
    }

    // 🔥 NEW TEST CASES

    @Test
    void testSearchBookById_NegativeId() {
        Book result = service.searchBookById(-1);
        assertNull(result);
    }

    @Test
    void testSearchBookById_ZeroId() {
        Book result = service.searchBookById(0);
        assertNull(result);
    }

    @Test
    void testSearchBookById_MultipleBooks() {
        Book book1 = new Book(1, "Java", "Author1", 3);
        Book book2 = new Book(2, "Python", "Author2", 4);

        BookRepository.addBook(book1);
        BookRepository.addBook(book2);

        Book result = service.searchBookById(2);

        assertNotNull(result);
        assertEquals("Python", result.getTitle());
    }

    @Test
    void testSearchBookById_AfterClear() {
        Book book = new Book(1, "Java Basics", "Gauri", 5);
        BookRepository.addBook(book);

        BookRepository.clearBooks();

        Book result = service.searchBookById(1);

        assertNull(result);
    }
}