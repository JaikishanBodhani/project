package com.barclays.book.resources;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.book.model.Book;
import com.barclays.book.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	BookService bookService;
	

    @GetMapping
    public HashMap<String, Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public Book findByTitle(@PathVariable String bookTitle) {
        return bookService.findOne(bookTitle);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }
}