package com.example.board.problem1.repository.memoryImpl;

import com.example.board.problem1.domain.Board;
import com.example.board.problem1.repository.BoardRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BoardMemoryRepository implements BoardRepository {
    private static int sequence = 0;

    private static final Map<Integer, Board> store = new HashMap<>();

    @Override
    public Board save(Board board) {
        board.setId(++sequence);
        store.put(sequence, board);

        return board;
    }

    @Override
    public Board findById(Integer id) {
        if(store.containsKey(id)) return store.get(id);
        throw new RuntimeException("존재하지 않는 아이디입니다.");
    }


}
