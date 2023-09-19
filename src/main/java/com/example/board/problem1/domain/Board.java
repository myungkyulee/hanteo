package com.example.board.problem1.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private Integer id;
    private List<Post> posts;


}
