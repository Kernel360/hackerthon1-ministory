package com.example.ministory.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "post")
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    private Long category_id;
    private Long user_id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp modifiedAt;
    private Long viewCount;
    private Long likeCount;
    private Long scrapCount;
}
