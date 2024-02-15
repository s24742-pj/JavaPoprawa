package com.example.s24742_librarymanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Short yearOfPublication;
    private String category;
    private Short availableCopies;
}
