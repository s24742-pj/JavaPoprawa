package com.example.s24742_librarymanagement.controller;

import com.example.s24742_librarymanagement.model.Book;
import com.example.s24742_librarymanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

   @PostMapping("/add")
   public ResponseEntity<Book> add(@RequestBody Book book){
       Book addedBook = bookService.addBook(book);

       return ResponseEntity
               .status(HttpStatusCode.valueOf(201))
               .body(addedBook);
   }

   @GetMapping("/findByID/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
       Book books = bookService.findById(id);

       return ResponseEntity
               .status(HttpStatusCode.valueOf(200))
               .body(books);

   }

   @GetMapping("/findByCategory/{category}")
    public ResponseEntity<List<Book>> findByCategory(@PathVariable String category) {
       List<Book> books = bookService.findBooksByCategory(category);

       return ResponseEntity
               .status(HttpStatusCode.valueOf(200))
               .body(books);
   }

}
