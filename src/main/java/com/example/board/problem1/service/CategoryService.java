package com.example.board.problem1.service;

import com.example.board.problem1.domain.Category;

public interface CategoryService {
    Category createCategory(Integer parentId, String name);
    Category findCategory(Integer id);
    Category findCategoryByName(String name);
    String changeCategoryToJson(Category category);
}
