package com.yummy.delivery.user.service;

import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.user.dto.AgreeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AgreeService {

    private final LoginService loginService;
    private final UserRepository userRepository;

    @Transactional
    public void agree(AgreeRequest agreeRequest) {

        User user = loginService.getLoggedInUserFromDatabase();

        user.updateAgree(agreeRequest);
        userRepository.save(user);
    }
}
