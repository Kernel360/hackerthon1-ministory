package com.example.ministory.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String nickname;
    private Date birthday;
    @Column(columnDefinition = "TEXT")
    private String imagePath;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String password;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean  isSocial;
    private String address;

}
