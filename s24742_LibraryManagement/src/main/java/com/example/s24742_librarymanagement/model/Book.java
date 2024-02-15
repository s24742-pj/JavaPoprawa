package com.example.s24742_librarymanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Integer id;
    private String tytul;
    private String autor;
    private int dataPublikacji;
    private String kategoria;
    private int dostepneKopie;
}
