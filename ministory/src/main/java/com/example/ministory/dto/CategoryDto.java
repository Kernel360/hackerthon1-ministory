package com.example.ministory.dto;

import com.example.ministory.entity.Category;
import com.example.ministory.entity.Post;
import com.example.ministory.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String title;

    public Category toEntity(User user) {
        return Category.builder()
                .categoryId(categoryId)
                .user(user)
                .title(title)
                .build();
    }
}
