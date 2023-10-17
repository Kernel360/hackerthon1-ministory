package com.example.ministory.dto;


import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.ministory.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Long userId;

    @Size(min = 4, message = "닉네임은 4글자 이상 이어야 합니다")
    @NotBlank(message = "닉네임은 필수항목입니다.")
    private String nickname;

    private String birthday;

    private String imagePath;

    @Email
    @NotBlank(message = "이메일은 필수항목입니다.")
    private String email;

    @Size(min = 8, max = 20, message = "비밀번호는 8자리 이상이어야 합니다.")
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    private boolean isSocial;

    @Size(min = 4, message = "블로그 주소는 4글자 이상 이어야 합니다")
    @NotBlank(message = "블로그 주소는 필수항목입니다.")
    private String address;

    @Builder
    public UserDto(Long userId, String nickname, String birthday, String imagePath, String email, String password,
        boolean isSocial, String address) {
        this.userId = userId;
        this.nickname = nickname;
        this.birthday = birthday;
        this.imagePath = imagePath;
        this.email = email;
        this.password = password;
        this.isSocial = isSocial;
        this.address = address;
    }

    public User toEntity() {
        User user = User.builder()
                .userId(userId)
                .nickname(nickname)
               .birthday(Timestamp.valueOf(birthday + " 00:00:00"))
                .imagePath(imagePath)
                .email(email)
                .password(password)
                .isSocial(isSocial)
                .address(address)
                .build();
          
        return user;
    }
}
