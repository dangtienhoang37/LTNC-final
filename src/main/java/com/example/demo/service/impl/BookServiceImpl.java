package com.example.demo.service.impl;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book Book) {
        bookRepository.save(Book);
    }
}
