package com.example.ministory.dto;

import com.example.ministory.entity.Post;
import com.example.ministory.entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {
    private Long postId;

    @NotBlank(message = "카테고리를 선택해주세요.")
    private Long categoryId;

    @NotBlank(message = "ERROR: 작성자 정보 없음")
    private Long userId;

    private String title;

    private String content;
}