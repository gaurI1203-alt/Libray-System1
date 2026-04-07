package library.service;

import library.repository.BookRepository;
import library.model.Book;

public class ReturnBookService {

    public void returnBook(int id) {

        Book book = BookRepository.findBookById(id);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        // ✅ Better design (use model method)
        book.returnBook();
    }
}