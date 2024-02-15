package com.example.s24742_librarymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.s24742_librarymanagement.model.Book;
import com.example.s24742_librarymanagement.repository.BookRepository;
import com.example.s24742_librarymanagement.expection.ValidationException;
import java.util.List;

import static com.example.s24742_librarymanagement.model.Category.*;


@Service
@AllArgsConstructor
public class BookService {


    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        if (book.getAuthor() == null || book.getAuthor().isEmpty()){
            throw new ValidationException("Autor nie moze być pusty");
        }
        if (book.getTitle() == null || book.getAuthor().isEmpty()) {
            throw new ValidationException("Tytuł nie może być pusty");
        }
        if (book.getYearOfPublication() == null || book.getYearOfPublication() <1450 || book.getYearOfPublication() >2024){
            throw new ValidationException("Rok nie moze być pusty i musi sie znajdowac w przedziale od 1450 roku do obecnego");
        }
        if (book.getAvailableCopies() == null || book.getAvailableCopies() < 0){
            throw new ValidationException("Liczba kopii ksiązki nie moze byc zerowa");
        }
        if (book.getCategory() == null || !(book.getCategory().equals(Literatura_piekna) || book.getCategory().equals(Naukowa) || book.getCategory().equals(Fantastyka))){
            throw new ValidationException("Kategoria nie moze byc pusta i musi zawierac ktoras z kategori Literatura piekna lub Naukowa lub Fantastyka");
        }
        return bookRepository.add(book);
    }

    public Book findById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Ksiazka o id"+ id + "nie zostala znaleziona"));
    }

    public List<Book> findBooksByCategory(String category) {
        List<Book> byCategory = bookRepository.findAllByCategory(category);

        if (byCategory.isEmpty()){
            throw new ValidationException("Ksiazka o podaje kategori "+ category +"nie zostala znaleziona");
        }

        return byCategory;
    }


}
