package com.PMgroup.BookManagement;

public class BookAlreadyExistException extends RuntimeException{
    public BookAlreadyExistException(int id)
    {
        super("Book with id "+id+" already exist");
    }
}
