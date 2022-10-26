package com.yummy.delivery.user.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.OrderRepository;
import com.yummy.delivery.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeService {

    private final UserRepository userRepository;
    private final LoginService loginService;
    private final OrderRepository orderRepository;

    public void updateGrade() {

        User user = loginService.getLoggedInUserFromDatabase();
        //유저 엔티티에서 그대로 가져온다면 오래된 데이터일 수 있기 때문에 데이터베이스에서 새로 정보를 가져와야 한다.

        Long count = orderRepository.countByUserId(user.getId());
        User.Grade grade = User.Grade.getGradeByOrderCount(count);

        if(user.getGrade() != grade) {
            user.updateGrade(grade);
            userRepository.save(user);
        }
    }
}
