package com.yummy.delivery.service;

import com.yummy.delivery.domain.Grade;
import com.yummy.delivery.domain.User;
import com.yummy.delivery.dto.UserRequestDTO;
import com.yummy.delivery.exception.UserIdExistedException;
import com.yummy.delivery.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final HttpSession httpSession;
    private final PasswordEncoder passwordEncoder;
    private final Integer INIT_COUNT = 0;
    private final String INIT_GRADE = "Bronze";

     /* 회원가입 */
    public void signUp(UserRequestDTO userDTO){

        User user = User.builder()
                .email(userDTO.getEmail())
                .password(encryptedPassword(userDTO))
                .name(userDTO.getName())
                .phone(userDTO.getPhone())
                .address(userDTO.getAddress())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userMapper.insertUser(user);

        insertGrade(user.getId());  //  회원등급 테이블(grade) 데이터 삽입
    }

    /* 회원탈퇴 */
    public void userWithdrawal(@Param("email") String email){
        userMapper.deleteUser(email);
    }

    /* 중복 이메일 확인 */
    public void checkSameEmail(@Param("email") String email){
        if(userMapper.isExistsEmail(email)){
            throw new UserIdExistedException("사용 중인 이메일입니다");
        }
    }

    /* 비밀번호 암호화 */
    public String encryptedPassword(UserRequestDTO userDTO){
        String encodePassword = passwordEncoder.encode(userDTO.getPassword());
        return encodePassword;
    }

    /* 회원등급(grade 테이블) 초기화 */
    public void insertGrade(Long userId){
        Grade grade = Grade.builder()
                .userId(userId)
                .count(INIT_COUNT)
                .grade(INIT_GRADE)
                .build();

        userMapper.insertGrade(grade);
    }

    /* 사용자 조회 */
    public UserRequestDTO getUserList(@Param("id") Long id){
        return userMapper.findAll(id);
    }


    public void login(UserRequestDTO userDTO) {
        String encodingWord = passwordEncoder.encode(userDTO.getPassword());

        User user = userMapper.findByEmailAndPassword(userDTO.getEmail(),
                encodingWord);

        validateExistUser(user);

        httpSession.setAttribute("USER_ID", user);

    }

    private void validateExistUser(User user) {
        Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void logout() {
        httpSession.removeAttribute("USER_ID");
    }

//    public Optional<User> findOne(String email){
//        return userMapper.findByEmail(email);
//    }

//    public List<User> findMembers(){
//        return userRepository.findAll();
//    }


}


/* @Param Annotation 방식 */
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