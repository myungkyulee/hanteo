package com.example.board.problem1.repository;

import com.example.board.problem1.domain.Category;

public interface CategoryRepository {
    Category save(Category category);
    Category findById(Integer id);
    Category findByName(String name);
    boolean existsBoardByName(String name);
}
