package com.example.ministory.service;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.entity.User;
import com.example.ministory.entity.Category;

import com.example.ministory.exception.NotFoundException;
import com.example.ministory.repository.UserRepository;
import com.example.ministory.repository.CategoryRepository;


import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Category> findUserCategory(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("해당하는 User가 없습니다."));
        return categoryRepository.findCategoriesByUser(user);
    }

    @Transactional
    public void saveCategoryOnUser(CategoryDto categoryDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("해당하는 User가 없습니다."));
        System.out.println(categoryDto.getTitle());
        Category category = categoryDto.toEntity(user);

        categoryRepository.save(category);
    }

    @Transactional
    public void updateCategory(Long categoryId, String title) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("해당하는 Category가 없습니다."));
        category.setTitle(title);
    }

    @Transactional
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
