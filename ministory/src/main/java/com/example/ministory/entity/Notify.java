package com.example.ministory.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.ministory.util.NotifyType;
import com.example.ministory.util.NotifyTypeConverter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "notify")
public class Notify {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notifyId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private Long parentId; // 이건 들어올 수 있는 엔티티가 너무 많아서 관계설정 안함

	@Convert(converter = NotifyTypeConverter.class)
	@Column(columnDefinition = "VARCHAR(20)")
	private NotifyType notifyType;

	private String notifyTitle;

	@Column(columnDefinition = "TEXT")
	private String notifyContent;

	@CreationTimestamp
	private Timestamp createdAt;

	@UpdateTimestamp
	private Timestamp checkedAt;

	private String notifyUrl;

	@Column(columnDefinition = "TINYINT(1)")
	private boolean isChecked;

}
