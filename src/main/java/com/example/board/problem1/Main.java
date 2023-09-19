package com.example.board.problem1;

import com.example.board.problem1.domain.Category;
import com.example.board.problem1.repository.memoryImpl.BoardMemoryRepository;
import com.example.board.problem1.repository.memoryImpl.CategoryMemoryRepository;
import com.example.board.problem1.service.BoardService;
import com.example.board.problem1.service.CategoryService;
import com.example.board.problem1.service.impl.BoardServiceImpl;
import com.example.board.problem1.service.impl.CategoryServiceImpl;

public class Main {



    public static void main(String[] args) {
        BoardService boardService = new BoardServiceImpl(new BoardMemoryRepository());
        CategoryService categoryService = new CategoryServiceImpl(
                new CategoryMemoryRepository(),
                boardService
        );

// 남자
        Category category1 = categoryService.createCategory(null, "남자");

        // 엑소
        Category category2 = categoryService.createCategory(category1.getId(), "엑소");
        Category category3 = categoryService.createCategory(category2.getId(), "공지사항");
        Category category4 = categoryService.createCategory(category2.getId(), "첸");
        Category category5 = categoryService.createCategory(category2.getId(), "백현");
        Category category6 = categoryService.createCategory(category2.getId(), "시우민");

        // 방탄소년단
        Category category10 = categoryService.createCategory(category1.getId(), "방탄소년단");
        Category category11 = categoryService.createCategory(category10.getId(), "공지사항");
        Category category12 = categoryService.createCategory(category10.getId(), "익명게시판");
        Category category13 = categoryService.createCategory(category10.getId(), "뷔");



        // 여자
        Category category21 = categoryService.createCategory(null, "여자");

        // 블랙핑크
        Category category22 = categoryService.createCategory(category21.getId(), "블랙핑크");
        Category category23 = categoryService.createCategory(category22.getId(), "공지사항");
        Category category24 = categoryService.createCategory(category22.getId(), "익명게시판");
        Category category25 = categoryService.createCategory(category22.getId(), "로제");


        Category manCategory = categoryService.findCategoryByName("남자");
        Category womanCategory = categoryService.findCategoryByName("여자");
        System.out.println(categoryService.changeCategoryToJson(manCategory));
        System.out.println(categoryService.changeCategoryToJson(womanCategory));
    }
}
