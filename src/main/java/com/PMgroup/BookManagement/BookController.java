package com.PMgroup.BookManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BookController {


    BookServices bookServices=new BookServices();
    @PostMapping("/add-book")
    public ResponseEntity addBook (@RequestBody Book book)
    {
        try {
            boolean added=bookServices.addBook(book);
            return new ResponseEntity("Added Successfully", HttpStatus.CREATED);
        }catch (BookAlreadyExistException exception)
        {
            return new ResponseEntity<>("book already exist",HttpStatus.valueOf(400));
        }
        catch (Exception e)
        {
            return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
        }

        //data.put(book.getBookId(),book);
        //return "Book with ID: "+book.getBookId()+" has added successfully";

    }
    @GetMapping("/find-book")
    public ResponseEntity findBook(@RequestParam int id)
    {
      try
      {

              Book book= bookServices.findBook(id);
              return new ResponseEntity<>(book,HttpStatus.OK);
      }
      catch (BookDoesntExistException exception)
      {
          return new ResponseEntity("Book not found",HttpStatus.valueOf(404));

      }
      catch (Exception e)
      {
          return new ResponseEntity("Something went wrong",HttpStatus.valueOf(500));
      }
    }
//    @GetMapping("/find-book/find-books/{id}")
//    public Book findBooks(@PathVariable int id)
//    {
//        return data.get(id);
//    }
//
    @PutMapping("/update-book/{id}")
    public String updateBook(@PathVariable int id,@RequestParam(required = false) String title,@RequestParam(required = false) String author,@RequestParam(required = false) Integer pages)
    {
       try {
          String response=bookServices.updateBook(id,title,author,pages);
          return response;
       }
       catch (Exception e)
       {
           return "Exception occurred";
       }
    }
//
//    @GetMapping("/all-books")
//    public List<Book> getAllBooks()
//    {
//
//       return data.values().stream().toList();
//    }
    @DeleteMapping("/remove-book/{id}")
    public ResponseEntity removeBook(@PathVariable int id)
    {
      try
      {
          bookServices.removeBook(id);
          return new ResponseEntity("book removed successfully",HttpStatus.OK);
      }
      catch (BookDoesntExistException exception)
      {
          return new ResponseEntity(exception.getMessage(),HttpStatus.valueOf(404));

      }
    }
}
