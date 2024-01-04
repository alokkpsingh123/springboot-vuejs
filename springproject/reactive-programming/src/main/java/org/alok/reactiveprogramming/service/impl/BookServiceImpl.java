package org.alok.reactiveprogramming.service.impl;

import jdk.jfr.internal.Utils;
import org.alok.reactiveprogramming.dto.BookDto;
import org.alok.reactiveprogramming.entity.Book;
import org.alok.reactiveprogramming.repository.BookRepository;
import org.alok.reactiveprogramming.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.beans.Beans;
import java.time.Duration;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    

    @Override
    public Mono<Book> create(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setPublisher(bookDto.getPublisher());
        book.setAuthor(bookDto.getAuthor());
        return bookRepository.save(book);
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll().delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Mono<Book> get(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(bookOld -> {
            bookOld.setAuthor(book.getAuthor());
            bookOld.setDescription(book.getDescription());
            bookOld.setPublisher(book.getPublisher());
            bookOld.setName(book.getName());
            return  bookRepository.save(bookOld);
        });
    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }
}
