package com.example.ministory.service;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.entity.User;
import com.example.ministory.entity.Category;

import com.example.ministory.repository.UserRepository;
import com.example.ministory.repository.CategoryRepository;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Category> findUserCategory(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        return categoryRepository.findCategoriesByUser(user);
    }

    @Transactional
    public void deleteCategory(CategoryDto request) {

    }

}
