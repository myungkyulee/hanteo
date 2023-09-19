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


        Solution solution = new Solution();

        int sum = 4;
        int[] coins = {1, 2, 3};

        System.out.println(solution.solution(sum, coins));

        sum = 10;
        coins = new int[]{2, 5, 3, 6};

        System.out.println(solution.solution(sum, coins));

        sum = 3;
        coins = new int[]{1, 2, 3, 4};

        System.out.println(solution.solution(sum, coins));

        BoardService boardService = new BoardServiceImpl(new BoardMemoryRepository());
        CategoryService categoryService = new CategoryServiceImpl(
                new CategoryMemoryRepository(),
                boardService
        );



        Category category1 = categoryService.createCategory(null, "남자");
        Category category2 = categoryService.createCategory(category1.getId(), "엑소");
        Category category3 = categoryService.createCategory(category2.getId(), "공지사항");
        Category category4 = categoryService.createCategory(category2.getId(), "첸");
        Category category5 = categoryService.createCategory(category2.getId(), "백현");
        Category category6 = categoryService.createCategory(category2.getId(), "시우민");



        System.out.println(category1.getChildIds());



        String str = categoryService.changeCategoryToJson(category1);
        System.out.println(str);

    }

}
