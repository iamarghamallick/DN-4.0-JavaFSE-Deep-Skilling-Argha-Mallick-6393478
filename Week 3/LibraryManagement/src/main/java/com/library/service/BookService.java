package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Inside BookRepository.addBook()");
        bookRepository.save();
    }

    public void testService() {
        System.out.println("Book Service is working...");
    }
}
