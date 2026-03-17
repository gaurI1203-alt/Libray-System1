package library.service;

import library.model.Book;
import library.repository.BookRepository;

public class IssueBookService {

    public static boolean issueBook(int id) {

        Book book = BookRepository.findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            System.out.println("Book issued successfully!");
            return true;
        }

        System.out.println("No copies available!");
        return false;
    }
}