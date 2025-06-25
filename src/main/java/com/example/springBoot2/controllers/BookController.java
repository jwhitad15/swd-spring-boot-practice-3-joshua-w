package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import org.springframework.web.bind.annotation.*;
import com.example.springBoot2.repositories.bookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
    private final bookRepository bookRepository;

    public BookController(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Book getAllItems(@RequestBody Book book) {
        return (Book) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getItem(@PathVariable int bookId) {
        return (Book) bookRepository.findById(bookId).orElse(null);
    }

    @PostMapping("/books")
    public Book addItem(@RequestBody Book book) {
        return (Book) bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateItem(@PathVariable int bookId, @RequestBody Book book) {
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteItem(@PathVariable int bookId) {
        bookRepository.deleteById(bookId);
    }
}
