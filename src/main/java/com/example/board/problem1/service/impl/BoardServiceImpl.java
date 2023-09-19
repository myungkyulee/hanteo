package com.example.board.problem1.service.impl;

import com.example.board.problem1.domain.Board;
import com.example.board.problem1.repository.BoardRepository;
import com.example.board.problem1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public Board createBoard() {

        return boardRepository.save(new Board());
    }
}
