package com.yummy.delivery.user.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.user.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;

    public void login(LoginRequest loginRequest) {
        User findUser = userRepository.findByEmail(loginRequest.getLoginId());

        validateExistUser(findUser);

        if(!passwordEncoder.matches(loginRequest.getPassword(), findUser.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        httpSession.setAttribute("USER_ID", User.builder()
                .email(loginRequest.getLoginId())
                .password(loginRequest.getPassword())
                .build());
    }

    private void validateExistUser(User user) {
        Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
    }

    public User getUserId() {
        return (User) Optional.ofNullable(httpSession.getAttribute("USER_ID"))
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
    }
}
