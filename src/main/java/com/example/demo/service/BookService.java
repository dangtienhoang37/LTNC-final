package com.example.demo.service;

import com.example.demo.models.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    List<Book> findBooksByTen(String ten);
}
