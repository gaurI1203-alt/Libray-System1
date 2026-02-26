package library.service;

import library.repository.BookRepository;
import library.model.Book;

public class SearchBookService {

    public Book searchBookById(int id) {
        return BookRepository.findBookById(id);
    }
}