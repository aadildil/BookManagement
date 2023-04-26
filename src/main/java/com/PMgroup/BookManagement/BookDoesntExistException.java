package com.PMgroup.BookManagement;

public class BookDoesntExistException extends RuntimeException{
    public BookDoesntExistException(int id) {
        super("book id " + id + " doesn't exist");
    }
}
