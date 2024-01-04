package org.alok.reactiveprogramming.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.alok.reactiveprogramming.helper.Helper;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("book_details")
public class Book {

    @Id
    @Column("book_id")
    private Integer bookId;
    private String name;
    @Column("book_desc")
    private String description;
    private String publisher;
    private String author;
}
