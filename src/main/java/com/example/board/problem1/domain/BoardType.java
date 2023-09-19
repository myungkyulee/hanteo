package com.example.board.problem1.domain;

import lombok.Getter;

public enum BoardType {
    ANONYMOUS_BOARD("익명게시판");

    @Getter
    private String name;

    BoardType(String name){
        this.name = name;
    }
}
