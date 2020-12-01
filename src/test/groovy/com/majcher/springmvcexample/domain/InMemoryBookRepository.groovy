package com.majcher.springmvcexample.domain

import groovy.transform.CompileStatic

@CompileStatic
class InMemoryBookRepository implements BookRepository {

    HashMap<Long, Book> books = new HashMap<>()

    @Override
    Book save(Book book) {
        return books.put(book.getId(), book)
    }

    @Override
    List<Book> findAll() {
        return books.values().toList()
    }
}
