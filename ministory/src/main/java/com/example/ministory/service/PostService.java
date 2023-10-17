package com.example.ministory.service;

import com.example.ministory.entity.Category;
import com.example.ministory.entity.User;
import com.example.ministory.repository.CategoryRepository;
import com.example.ministory.repository.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Category> findUserCategory(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        return categoryRepository.findCategoriesByUser(user);
    }
}
