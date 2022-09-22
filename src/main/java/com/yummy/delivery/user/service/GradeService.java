package com.yummy.delivery.user.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeService {

    private final UserRepository userRepository;

    public void updateGrade(User user, Long count) {

        User.Grade grade = User.Grade.getGradeByOrderCount(count); //count를 조회한 것

        if(user.getGrade() != grade) {
            user.updateGrade(grade);
            userRepository.save(user);
        }
    }
}
