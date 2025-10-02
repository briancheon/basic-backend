package com.example.demo.todo;

import lombok.Getter;
import lombok.Builder;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoDto {
    long id;
    String title;
    Boolean completed;
}

