package com.example.ministory.service;

import com.example.ministory.entity.Category;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;
import com.example.ministory.repository.CategoryRepository;
import com.example.ministory.repository.PostRepository;
import com.example.ministory.repository.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new RuntimeException());
    }
    public List<Category> findUserCategory(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        return categoryRepository.findCategoriesByUser(user);
    }

    public void writePost(Map<Object, Object> map) {
        String title = (String) map.get("title");
        Long categoryId = Long.parseLong((String) map.get("category_id"));
        String markdownContent = (String) map.get("content_md");
        String htmlContent = (String) map.get("content_html");

        Post post = new Post(categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException()),
                userRepository.findById(Long.valueOf(1)).orElseThrow(() -> new RuntimeException()),
                title, htmlContent, markdownContent);

        postRepository.save(post);
    }



}
