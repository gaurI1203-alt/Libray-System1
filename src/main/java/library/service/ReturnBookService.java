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

        if (book.getAvailableCopies() < book.getTotalCopies()) {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            System.out.println("Book returned successfully");
        } else {
            System.out.println("All copies already in library");
        }
    }
}