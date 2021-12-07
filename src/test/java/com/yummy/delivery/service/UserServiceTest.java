package com.yummy.delivery.service;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    @Test
    void 회원가입() {
        //given
        User user = new User(
                "lwg0907@naver.com",
                "lee0079",
                "이원기",
                "010-5059-9576",
                "수원시 장안구 영화동"
                );

        //when
        String saveEmail = userService.signUp(user);

        //then
        User findMember = userService.findOne(saveEmail).get();
        assertThat(user.getEmail()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_이메일_확인() {
        //given
        User user1 = new User("lwg0907@naver.com",
                "lee0079",
                "이원기",
                "010-5059-9576",
                "수원시 장안구 영화동"
        );

        User user2 = new User("log19951@gmail.com",
                "lee0079",
                "이원기",
                "010-5059-9576",
                "수원시 장안구 영화동"
        );

        //when
        userService.signUp(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.signUp(user2));

        assertThat(e.getMessage()).isEqualTo("Same Email existed : " + user1.getEmail());

    }

}


