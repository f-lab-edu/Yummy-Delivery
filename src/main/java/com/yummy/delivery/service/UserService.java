package com.yummy.delivery.service;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.dto.UserDTO;
import com.yummy.delivery.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final HttpSession httpSession;
    private final PasswordEncoder passwordEncoder;

    public void login(UserDTO userDTO) {
        String encodingWord = passwordEncoder.encode(userDTO.getPassword());

        User user = userMapper.findByEmailAndPassword(userDTO.getEmail(),
                encodingWord);

        validateExistUser(user);

        httpSession.setAttribute("USER_ID", user);

    }

    private void validateExistUser(User user) {
        Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void logout() {
        httpSession.removeAttribute("USER_ID");
    }

}