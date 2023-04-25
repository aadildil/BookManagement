package com.PMgroup.BookManagement;

import java.util.Optional;

public class BookServices {
    BookRepository bookRepository=new BookRepository();
    public  boolean addBook(Book book) throws BookAlreadyExistException{
        Optional<Book> book1=bookRepository.getById(book.getBookId());
        if(book1.isPresent())
        {
            throw new BookAlreadyExistException(book.getBookId());
        }
        return bookRepository.addBook(book);

    }
}
