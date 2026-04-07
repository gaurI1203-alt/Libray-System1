package library.service;

import library.model.Book;
import library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchBookServiceTest {

    @BeforeEach
    void setup() {
        // Clear previous data before each test
        BookRepository.clearBooks();
    }

    @Test
    void testSearchBookById_Found() {
        // Arrange
        Book book = new Book(1, "Java Basics", "Gauri", 5);
        BookRepository.addBook(book);

        SearchBookService service = new SearchBookService();

        // Act
        Book result = service.searchBookById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Java Basics", result.getTitle());
        assertEquals("Gauri", result.getAuthor());
    }

    @Test
    void testSearchBookById_NotFound() {
        // Arrange
        SearchBookService service = new SearchBookService();

        // Act
        Book result = service.searchBookById(999);

        // Assert
        assertNull(result);
    }
}