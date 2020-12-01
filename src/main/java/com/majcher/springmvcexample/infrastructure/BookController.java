package com.majcher.springmvcexample.infrastructure;

import com.majcher.springmvcexample.domain.Book;
import com.majcher.springmvcexample.domain.BookDto;
import com.majcher.springmvcexample.domain.Facade;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class BookController {

    Facade facade;

    @GetMapping("/books")
    List<BookDto> getBooks() {
        return facade.showBooks().stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
    }
}
