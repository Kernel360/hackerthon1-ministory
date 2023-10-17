package com.example.ministory.repository;

import com.example.ministory.entity.Category;
import com.example.ministory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>  {
    List<Category> findCategoriesByUser(User user);
}
