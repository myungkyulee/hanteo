package com.example.board.problem1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Category {
    private Integer id;
    private String name;

    private List<Integer> childIds;

    private Integer boardId;

    public Category(String name) {
        this.name = name;
        this.childIds = new LinkedList<>();
    }
}
