package com.yummy.delivery.controller;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.dto.UserDTO;
import com.yummy.delivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.yummy.delivery.httpStatus.httpComponent.RESPONSE_ENTITY_OK;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    /* 아이디(이메일) 중복확인 */
    @GetMapping("/signup/{email}")
    public void checkSameEmail(@PathVariable("email") String email) {
        userService.checkSameEmail(email);
    }

    /* 회원가입 */
    @PostMapping("/signup")
    public void signUp(User user) {
        userService.checkNullData(user);    //  회원정보를 모두 기입했는지 확인하는 메서드
        userService.checkPasswordLength(user);  //  비밀번호를 8자리 이상 기입했는지 확인하는 메서드
        userService.signUp(user);
    }

    /* 회원 탈퇴 */
    @DeleteMapping("mypage/{email}")
    public void userWithdrawal(@PathVariable("email") String email) {
        userService.userWithdrawal(email);
    }


    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDTO userDTO) {
        userService.login(userDTO);
        return RESPONSE_ENTITY_OK;
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        userService.logout();
        return RESPONSE_ENTITY_OK;
    }
}

/* @Param Annotation 방식 */
//@PostMapping("/user")
//    public void signUp(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        userService.signUp(email, password, name, phone, address);
//    }
