package org.alok.reactiveprogramming.service;

import org.alok.reactiveprogramming.dto.BookDto;
import org.alok.reactiveprogramming.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> create(BookDto bookDto);

    Flux<Book> getAll();

    Mono<Book> get(int bookId);

    Mono<Book> update(Book book, int bookId);

    Mono<Void> delete(int bookId);

    Flux<Book> search(String query);

}
