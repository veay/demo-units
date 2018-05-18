package com.lee.entity;

import lombok.Data;

@Data
public class Book {
    private Long bookId;

    private String name;

    private Integer number;


    public Book() {
    }

    public Book(long bookId, String name, int number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

}