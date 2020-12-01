package com.majcher.springmvcexample.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BookConfiguration {

    @Bean
    Facade facade(BookRepository bookRepository) {
        return new Facade(bookRepository);
    }
}
