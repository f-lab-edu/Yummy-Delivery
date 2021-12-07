package com.yummy.delivery.service;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public String signUp(User user)  {
        if(userRepository.isExistsEmail(user.getEmail())){
            throw new IllegalStateException("Same Email existed : " + user.getEmail());
        }
        userRepository.insertUser(user);

        return user.getEmail();
    }

    public boolean checkSameEmail(String email){
        return userRepository.isExistsEmail(email);
    }

    public Optional<User> findOne(String email){
        return userRepository.findByEmail(email);
    }

//    public List<User> findMembers(){
//        return userRepository.findAll();
//    }



}
