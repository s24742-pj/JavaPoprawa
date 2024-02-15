package com.example.s24742_librarymanagement.Service;

import com.example.s24742_librarymanagement.model.Book;
import com.example.s24742_librarymanagement.repository.BookRepository;
import com.example.s24742_librarymanagement.service.BookService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeAll
    static void setUp() {
        BookRepository = new BookRepository();
        BookService = new BookService();
    }

    @Test
    void addBookSuccess(){
        Book book = new Book();
        book.setTitle("Test");
        book.setAuthor("Author");
        book.setCategory("Fantasy");
        book.setYearOfPublication((short) 2023);
        book.setAvailableCopies((short) 3);
    }
}
