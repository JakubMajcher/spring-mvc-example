package com.majcher.springmvcexample.domain

import spock.lang.Specification
import spock.lang.Subject

class FacadeSpec extends Specification {

    @Subject
    Facade facade

    BookRepository bookRepository

    def setup() {
        bookRepository = new InMemoryBookRepository()
        facade = new Facade(bookRepository)
    }

    def "having book and save it to repository"() {
        given:
        Book book = Book.builder().id(1).title("Some title").build()
        when:
            facade.addBook(book)
        then:
            book in facade.showBooks()
    }
}
