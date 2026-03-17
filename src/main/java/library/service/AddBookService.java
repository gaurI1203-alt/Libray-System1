package library.service;

import library.model.Book;
import library.repository.BookRepository;

public class AddBookService {

    public void addBook(int id, String title, String author, int totalCopies) {

        Book existingBook = BookRepository.findBookById(id);
        if (existingBook != null) {
            System.out.println("Book with this ID already exists!");
            return;
        }

        Book book = new Book(id, title, author, totalCopies);
        BookRepository.addBook(book);

        System.out.println("Book added successfully!");
    }

    public void displayBooks() {

        if (BookRepository.getAllBooks().isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : BookRepository.getAllBooks()) {
            System.out.println(book);
        }
    }
}