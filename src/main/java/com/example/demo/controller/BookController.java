package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.ResponseObj;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Books")
public class BookController {
    @Autowired
    private BookRepository repository;
    // dang req: http://localhost:8081/api/v1/Books
    @GetMapping("")
    List<Book> getAllBooks() {
        return repository.findAll();
    }
    // get detail book
    @GetMapping("/{id}")
    ResponseEntity<ResponseObj> findById(@PathVariable Integer id){
        Optional<Book> foundBook = repository.findById(id);
        if(foundBook.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("ok", "Query book successfully", foundBook)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObj("false", "Cannot find book with id = "+id, "")
            );
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("ten") String ten) {
        List<Book> books = bookService.findBooksByTen(ten);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //Inset
    //Postman : raw. JSON
    @Autowired
    private BookService bookService;
    @PostMapping("/insert")
    public ResponseObj insertBook(@RequestBody Book book){
        bookService.addBook(book);

        return new ResponseObj("200","register Sucessfully!",book);
    }
    //update, upsert = update if found, otherwise insert
    //@PutMapping("/update/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<ResponseObj> updateBook(@RequestBody Book newBook, @PathVariable Integer id){
        Book updateBook = repository.findById(id)
                .map(book -> {
                    book.setTen(newBook.getTen());
                    book.setTacGia(newBook.getTacGia());
                    book.setViTri(newBook.getViTri());
                    book.setNgayXuatBan(newBook.getNgayXuatBan());
                    return repository.save(book);
                }).orElseGet(()->{
                    newBook.setId(id);
                    return repository.save(newBook);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObj("OK", "Update book successfully", updateBook)
        );
    }
    //delete
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObj> deleteBook(@PathVariable Integer id){
        boolean exists = repository.existsById(id);
        if(exists){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObj("ok", "Delete book successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObj("ok", "Cannot find book to delete", "")
        );
    }
}
