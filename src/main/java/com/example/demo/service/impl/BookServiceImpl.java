package com.example.demo.service.impl;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksByTen(String ten) {
        return bookRepository.findByTenContaining(ten);
    }
}
