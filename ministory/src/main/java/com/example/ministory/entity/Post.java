package com.example.ministory.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String title;

	@Column(columnDefinition = "TEXT")
	private String htmlContent;

	@Column(columnDefinition = "TEXT")
	private String markdownContent;

	@CreationTimestamp
	private Timestamp createdAt;

	@UpdateTimestamp
	private Timestamp modifiedAt;

	private Long viewCount;

	private Long likeCount;

	private Long scrapCount;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Likes> likeList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Scrap> scrapList = new ArrayList<>();

	public Post(Category category, User user, String title, String htmlContent, String markdownContent) {
		this.category = category;
		this.user = user;
		this.title = title;
		this.htmlContent = htmlContent;
		this.markdownContent = markdownContent;
		this.likeCount = Long.valueOf(0);
		this.viewCount = Long.valueOf(0);
		this.scrapCount = Long.valueOf(0);
	}
}


