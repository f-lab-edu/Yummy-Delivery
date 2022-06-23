package com.yummy.delivery.core.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.user.dto.CreateUserRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  @Transactional
  public void signUp(CreateUserRequest createUserRequest) {
    boolean exist = userRepository.existsByEmailEqualsIgnoreCase(createUserRequest.getEmail());
    if (exist) {
      throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
    }

    String hashed = passwordEncoder.encode(createUserRequest.getPassword());
    User user = User.create(createUserRequest, hashed);
    userRepository.save(user);
  }
}
