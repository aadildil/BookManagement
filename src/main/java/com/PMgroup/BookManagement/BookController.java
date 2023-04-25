package com.PMgroup.BookManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class BookController {


    BookServices bookServices=new BookServices();
    @PostMapping("/add-book")
    public ResponseEntity addBook (@RequestBody Book book) throws BookAlreadyExistException
    {
        try {
            boolean added=bookServices.addBook(book);
            return new ResponseEntity("Added Successfully", HttpStatus.CREATED);
        }catch (BookAlreadyExistException exception)
        {
            return new ResponseEntity<>("book already exist",HttpStatus.valueOf(400));
        }

        //data.put(book.getBookId(),book);
        //return "Book with ID: "+book.getBookId()+" has added successfully";

    }
//    @GetMapping("/find-book")
//    public Book findBook(@RequestParam int id)
//    {
//        if(!data.containsKey(id))
//            return null;
//        return data.get(id);
//    }
//    @GetMapping("/find-book/find-books/{id}")
//    public Book findBooks(@PathVariable int id)
//    {
//        return data.get(id);
//    }
//
//    @PutMapping("/update-book/{id}")
//    public String updateBook(@PathVariable int id,@RequestParam(required = false) String title,@RequestParam(required = false) String author,@RequestParam(required = false) int pages)
//    {
//        Book book=data.get(id);
//        if(book==null)
//            return "book ID doesn't exist";
//        if(author!=null)
//        book.setAuthor(author);
//        if(title!=null)
//        book.setTitle(title);
//        if(pages!=0)
//        book.setPages(pages);
//        data.put(id,book);
//        return "book details updated";
//    }
//
//    @GetMapping("/all-books")
//    public List<Book> getAllBooks()
//    {
//
//       return data.values().stream().toList();
//    }
//    @DeleteMapping("/remove-book/{id}")
//    public String removeBook(@PathVariable int id)
//    {
//        if(!data.containsKey(id))
//            return "Book ID doesn't exist";
//        data.remove(id);
//        return "Book removed";
//    }
}
