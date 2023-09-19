package com.example.board;

import com.example.board.problem1.domain.Category;
import com.example.board.problem1.repository.memoryImpl.BoardMemoryRepository;
import com.example.board.problem1.repository.memoryImpl.CategoryMemoryRepository;
import com.example.board.problem1.service.BoardService;
import com.example.board.problem1.service.CategoryService;
import com.example.board.problem1.service.impl.BoardServiceImpl;
import com.example.board.problem1.service.impl.CategoryServiceImpl;
import com.example.board.problem2.Solution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

}
