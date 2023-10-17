package com.example.ministory.dto;

import com.example.ministory.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserEntityDto {
    private Long userId;

    @Size(min = 4, message = "닉네임은 4글자 이상 이어야 합니다")
    @NotBlank(message = "닉네임은 필수항목입니다.")
    private String nickname;

    @Past
    private Date birthday;

    private String imagePath;

    @Email
    @NotBlank(message = "이메일은 필수항목입니다.")
    private String email;

    @Size(min = 8, max = 20, message = "비밀번호는 8자리 이상이어야 합니다.")
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    private String passwordConfirm;

    private boolean  isSocial;

    @Size(min = 4, message = "블로그 주소는 4글자 이상 이어야 합니다")
    @NotBlank(message = "블로그 주소는 필수항목입니다.")
    private String address;

    public UserEntity toEntity() {
        UserEntity userEntity = UserEntity.builder()
                .userId(userId)
                .nickname(nickname)
                .birthday(birthday)
                .imagePath(imagePath)
                .email(email)
                .password(password)
                .isSocial(isSocial)
                .address(address)
                .build();

        return userEntity;
    }
}
