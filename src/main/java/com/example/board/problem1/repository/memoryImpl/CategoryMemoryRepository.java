package com.example.board.problem1.repository.memoryImpl;

import com.example.board.problem1.domain.Category;
import com.example.board.problem1.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CategoryMemoryRepository implements CategoryRepository {

    private static int sequence = 0;

    private static final Map<Integer, Category> store = new HashMap<>();


    @Override
    public Category save(Category category) {
        category.setId(++sequence);
        store.put(sequence, category);

        return category;
    }

    @Override
    public Category findById(Integer id) {
        if(store.containsKey(id)) return store.get(id);
        throw new RuntimeException("존재하지 않는 아이디입니다.");
    }

    // full 스캔이라 비효율적
    @Override
    public Category findByName(String name) {
        return store.values().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("존재하지 않는 카테고리입니다."));
    }

    @Override
    public boolean existsBoardByName(String name) {
        return store.values().stream()
                .anyMatch(c -> c.getName().equals(name));
    }
}
