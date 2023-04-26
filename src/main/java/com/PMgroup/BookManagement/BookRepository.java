package com.PMgroup.BookManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepository {
    Map<Integer,Book> data=new HashMap<>();


    public boolean addBook(Book book) {
        data.put(book.getBookId(),book);
        return true;
    }
    public Optional<Book> getById(int id)
    {
        if(data.containsKey(id))
            return Optional.of(data.get(id));
        else
            return Optional.empty();
    }


    public void removeBookById(int id) {
        data.remove(id);
    }
}
