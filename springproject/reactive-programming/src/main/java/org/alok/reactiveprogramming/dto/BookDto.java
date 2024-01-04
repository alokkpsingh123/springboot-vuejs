package org.alok.reactiveprogramming.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
@Data
public class BookDto {
    private String name;
    private String description;
    private String publisher;
    private String author;
}
