package com.example.board.problem1.repository;

import com.example.board.problem1.domain.Board;

public interface BoardRepository {

    Board save(Board board);
    Board findById(Integer id);

}
