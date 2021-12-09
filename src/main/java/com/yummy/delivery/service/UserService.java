package com.yummy.delivery.service;

import com.yummy.delivery.domailn.User;
import com.yummy.delivery.dto.UserDTO;
import com.yummy.delivery.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final HttpSession httpSession;

    public void login(UserDTO userDTO) {
        User user = userMapper.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());

        validateExistUser(user);

        httpSession.setAttribute("ID", user);

    }

    private void validateExistUser(User user) {
        Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
    }

}