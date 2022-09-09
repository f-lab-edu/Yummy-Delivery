package com.yummy.delivery.user.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.user.dto.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class UpdateProfileService {

    private final UserRepository userRepository;
    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void update(UpdateUserRequest updateUserRequest) {

        User user = loginService.getLoggedInUserFromSession();
        user = userRepository.findByEmail(user.getEmail());

        Function<String, String> hashFunc = passwordEncoder::encode;

        user.update(updateUserRequest, hashFunc);
        userRepository.save(user);
    }
}
