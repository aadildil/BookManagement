package com.PMgroup.BookManagement;

import java.util.Objects;
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
    public Book findBook(int id) throws BookDoesntExistException
    {
        Optional<Book> book=bookRepository.getById(id);
        if(book.isEmpty())
            throw new BookDoesntExistException(id);
        return book.get();
    }

    public String updateBook(int id, String title, String author, Integer pages)  {

        try {
            Book book = findBook(id);

            if (Objects.nonNull(title)) {
                book.setTitle(title);
            }
            if (Objects.nonNull(author)) {
                book.setAuthor(author);
            }
            if (Objects.nonNull(pages)) {
                book.setPages(pages);
            }

            bookRepository.addBook(book);
            return "Book updated";

        }
        catch (BookDoesntExistException exception)
        {
            Book book=new Book(id,title,author,pages);
            addBook(book);
            return "Book created";
        }


    }

    public boolean removeBook(int id) {
        Optional<Book> book=bookRepository.getById(id);
        if(book.isEmpty())
            throw new BookDoesntExistException(id);
        bookRepository.removeBookById(id);
        return true;


    }
}
