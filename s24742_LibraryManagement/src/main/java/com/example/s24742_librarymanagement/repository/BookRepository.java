package com.example.s24742_librarymanagement.repository;

import com.example.s24742_librarymanagement.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BookRepository {
    List<Book> books = new ArrayList<>();

    public Book add(Book book){
        book.setId(books.size() + 1);
        books.add(book);
        return book;
    }


    public Optional<Book> findById(Integer id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public List<Book> findAllByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .toList();
    }

    public void clear(){
        books = new ArrayList<>();
    }

}
