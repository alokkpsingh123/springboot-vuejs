package org.alok.reactiveprogramming.controller;

import org.alok.reactiveprogramming.dto.BookDto;
import org.alok.reactiveprogramming.entity.Book;
import org.alok.reactiveprogramming.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    ResponseEntity<?> createBook(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.create(bookDto));
    }

    @GetMapping
    Flux<Book> getAllBook(){
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    ResponseEntity<?> getById(@PathVariable("bookId") int bookId){
        return ResponseEntity.ok(bookService.get(bookId));
    }

    @PutMapping
    ResponseEntity<?> updateBook(@RequestParam int bookId, @RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book, bookId));
    }

    @DeleteMapping
    ResponseEntity<?> deleteBook(@RequestParam int bookId){
        return ResponseEntity.ok(bookService.delete(bookId));
    }

}
