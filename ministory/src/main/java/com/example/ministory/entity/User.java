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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String nickname;

	private Timestamp birthday;

	@Column(columnDefinition = "TEXT")
	private String imagePath;

	private String email;

	@Column(columnDefinition = "TEXT")
	private String password;

	@Column(columnDefinition = "TINYINT(2)")
	private boolean isSocial;

	private String address;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Category> categoryList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> postList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Likes> likeList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Scrap> scrapList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Notify> notifyList = new ArrayList<>();

	public void addLikes(Long userId, Long postId) {
		likeList.add(Likes.builder()
			.user(User.builder().userId(userId).build())
			.post(Post.builder().postId(postId).build())
			.build());
	}

	public void addScrap(Long userId, Long postId) {
		scrapList.add(Scrap.builder()
			.user(User.builder().userId(userId).build())
			.post(Post.builder().postId(postId).build())
			.build());
	}
}
