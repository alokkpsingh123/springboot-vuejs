package org.alok.reactiveprogramming.repository;

import org.alok.reactiveprogramming.entity.Book;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableR2dbcRepositories
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {
}
