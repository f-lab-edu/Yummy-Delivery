package com.yummy.delivery.service;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.dto.UserDTO;
import com.yummy.delivery.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final HttpSession httpSession;
    private final PasswordEncoder passwordEncoder;

     /* 회원가입 */
    public void signUp(User user){
        encryptedPassword(user);    //  비밀번호 암호화
        saveInitialTime(user);     //  생성시간, 수정시간 저장
        userMapper.insertUser(user);
    }

    /* 회원탈퇴 */
    public void userWithdrawal(@Param("email") String email){
        userMapper.deleteUser(email);
    }

    /* 중복 이메일 확인 */
    public void checkSameEmail(@Param("email") String email){
        if(userMapper.isExistsEmail(email)){
            throw new IllegalStateException("사용 중인 이메일입니다");
        }
    }

    /* null 값 확인 */
    public void checkNullData(User user){
        if(user.getEmail() == null || user.getPassword() ==null || user.getName() == null ||
                user.getPhone() == null || user.getAddress() == null){
            throw new NullPointerException("회원정보를 모두 기입해주세요");
        }
    }

    /* 비밀번호 길이 확인 */
    public void checkPasswordLength(User user){
        if(user.getPassword().length() < 8){
            throw new IllegalStateException("비밀번호를 8자리 이상 입력해주세요.");
        }
    }

    /* 비밀번호 암호화 */
    public void encryptedPassword(User user){
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
    }

    public void saveInitialTime(User user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
    }

    public List<User> getUserList(){
        return userMapper.findAll();
    }

    public void login(UserDTO userDTO) {
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