package com.yummy.delivery.service;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired private UserMapper userMapper;
    @Autowired private PasswordEncoder passwordEncoder;


    public void signUp(User user){

        if(userMapper.isExistsEmail(user.getEmail())){
            throw new IllegalStateException("Same Email existed : " + user.getEmail());
        }

        String encodePassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodePassword);
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());

        userMapper.insertUser(user);
    }

    public List<User> getUserList(){
        return userMapper.findAll();
    }


//    public Optional<User> findOne(String email){
//        return userMapper.findByEmail(email);
//    }

//    public List<User> findMembers(){
//        return userRepository.findAll();
//    }


}


/* 파라미터 방식*/
//    public void signUp(@Param("email") String email, @Param("password") String password,
//                       @Param("name") String name, @Param("phone") String phone, @Param("address") String address) {
//        if(userMapper.isExistsEmail(email)){
//            throw new IllegalStateException("Same Email existed : " + email);
//        }
//        String encodePassword = passwordEncoder.encode(password);
//
//        LocalDateTime created_at = LocalDateTime.now();
//        LocalDateTime updated_at = LocalDateTime.now();
//
//        userMapper.insertUser(email, encodePassword, name, phone, address, created_at, updated_at);
//
//    }