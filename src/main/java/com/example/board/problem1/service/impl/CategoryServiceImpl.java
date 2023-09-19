package com.example.board.problem1.service.impl;

import com.example.board.problem1.domain.Board;
import com.example.board.problem1.domain.BoardType;
import com.example.board.problem1.domain.Category;
import com.example.board.problem1.repository.CategoryRepository;
import com.example.board.problem1.service.BoardService;
import com.example.board.problem1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.example.board.problem1.domain.BoardType.ANONYMOUS_BOARD;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final BoardService boardService;

    @Override
    public Category findCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category createCategory(Integer parentId, String name) {
        Category category = new Category(name);

        // 익명게시판을 만들 때 만약 익명게시판이 있다면 익명게시판으로 게시판을 설정
        if (ANONYMOUS_BOARD.getName().equals(name) && categoryRepository.existsBoardByName(name)) {
            Integer boardId = categoryRepository.findByName(ANONYMOUS_BOARD.getName()).getBoardId();
            category.setBoardId(boardId);
        } else {
            Board board = boardService.createBoard();
            category.setBoardId(board.getId());
        }

        Category savedCategory = categoryRepository.save(category);

        if (!Objects.isNull(parentId)) {
            categoryRepository.findById(parentId).getChildIds().add(savedCategory.getId());
        }

        return savedCategory;
    }

    public String changeCategoryToJson(Category category) {
        StringBuilder sb = new StringBuilder().append("{")
                .append("id"+ ":"+category.getId() )
                .append(",")
                .append("name"+ ":"+category.getName())
                .append(",");
        if (!category.getChildIds().isEmpty()) {
            for (Integer childId : category.getChildIds()) {
                sb.append(changeCategoryToJson(categoryRepository.findById(childId))).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("boardId"+ ":"+category.getBoardId());
        }

        sb.append("}");

        return sb.toString();
    }
}
