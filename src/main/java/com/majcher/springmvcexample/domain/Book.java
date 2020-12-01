package com.majcher.springmvcexample.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class Book {
    @NonNull
    Long id;
    @NonNull
    String title;

    public BookDto toDto() {
        return BookDto.builder()
                .id(id)
                .title(title)
                .build();
    }
}
