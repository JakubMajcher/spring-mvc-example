package com.majcher.springmvcexample.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class BookDto {
    @NonNull
    Long id;
    @NonNull
    String title;
}
