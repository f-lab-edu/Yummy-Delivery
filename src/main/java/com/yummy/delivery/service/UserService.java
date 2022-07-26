package com.yummy.delivery.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.user.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public User signUp(CreateUserRequest createUserRequest) {
        boolean emailExist = userRepository.existsByEmailEqualsIgnoreCase(createUserRequest.getEmail());

        if(emailExist) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String hashed = passwordEncoder.encode(createUserRequest.getPassword());

        User user = User.create(createUserRequest, hashed);

        return userRepository.save(user);
    }

}

