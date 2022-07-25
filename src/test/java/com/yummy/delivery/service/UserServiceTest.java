package com.yummy.delivery.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.user.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Transactional
    @Test
    void userSignUpTest() throws Exception {
        //given
        String email = "test@email.com";
        String name = "ddd";
        String password = "ddddd";
        String phone = "010-1234-5678";
        String address = "aaa aaa";
        CreateUserRequest createUserRequest = new CreateUserRequest(
                email, name, password, phone, address
        );

        //when
        User result = userService.signUp(createUserRequest);

        //then
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    void user_예외() throws Exception {
        String email = "test@email.com";
        String name = "ddd";
        String password = "aaaaa";
        String phone = "010-1111-2222";
        String address = "ddd ddd";

        CreateUserRequest createUserRequest = new CreateUserRequest(
                email, name, password, phone, address);

        try {
            userService.signUp(createUserRequest);
        } catch (Exception e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }

    }
}
