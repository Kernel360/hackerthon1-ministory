package com.example.ministory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.ministory.dto.UserDto;
import com.example.ministory.entity.User;
import com.example.ministory.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public Long saveUser(UserDto userDto) {
		return userRepository.save(userDto.toEntity()).getUserId();
	}

	public List<User> findUsers() {
		return userRepository.findAll();
	}
}
