package com.example.ministory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ministory.dto.CategoryDto;
import com.example.ministory.entity.Category;
import com.example.ministory.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public List<Category> saveCategory(CategoryDto categoryDto) {return categoryRepository.save(CategoryDto.toEn)}
	public List<Category> findCategory() { return categoryRepository.findAll();}
	public deleteCategory() {;}
}
