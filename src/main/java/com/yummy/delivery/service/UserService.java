package com.yummy.delivery.service;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired private UserMapper userMapper;
    @Autowired private PasswordEncoder passwordEncoder;


    public void signUp(@Param("email") String email, @Param("password") String password,
                       @Param("name") String name, @Param("phone") String phone, @Param("address") String address) {
        if(userMapper.isExistsEmail(email)){
            throw new IllegalStateException("Same Email existed : " + email);
        }
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setName(name);
//        user.setPhone(phone);
//        user.setAddress(address);

        String encodePassword = passwordEncoder.encode(password);

        LocalDateTime created_at = LocalDateTime.now();
        LocalDateTime updated_at = LocalDateTime.now();

        userMapper.insertUser(email, encodePassword, name, phone, address, created_at,updated_at);

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
