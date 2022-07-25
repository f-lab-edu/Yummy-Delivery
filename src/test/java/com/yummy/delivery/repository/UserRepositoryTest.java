package com.yummy.delivery.repository;

import com.yummy.delivery.core.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @org.junit.jupiter.api.Test
    public void existsByEmailEqualsIgnoreCase_테스트() {
        //given
        String email = "ehawson0@jimdo.com";

        //when
        boolean isExist = userRepository.existsByEmailEqualsIgnoreCase(email);

        //then
        Assertions.assertTrue(isExist);
    }

}
