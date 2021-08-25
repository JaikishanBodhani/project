package com.barclays.book.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.barclays.book.exception.BookException;
import com.barclays.book.model.Book;

@Service
public class BookService {
	
	HashMap<String, Book> bookMap = new HashMap<String, Book>();
	
	public Book findOne(String title) {
        return bookMap.get(title);
    }
	
	 public HashMap<String, Book> findAll() {
        return bookMap;
    }
	 
	public Book create(Book book) {
		if(bookMap.containsKey(book.getTitle())) {
			throw new BookException();
		}
		return bookMap.put(book.getTitle(),book);
        
    }

	

}
