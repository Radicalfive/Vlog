package com.mqxu.vlog.service;

import com.mqxu.vlog.VlogApiApplication;
import com.mqxu.vlog.common.Gender;
import com.mqxu.vlog.mapper.UserMapper;
import com.mqxu.vlog.model.dto.LoginDto;
import com.mqxu.vlog.model.dto.PhoneLoginDto;
import com.mqxu.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .phone("13951905171")
                .password("123123")
                .build();
        boolean flag = userService.login(loginDto);
        assertTrue(flag);
    }

    @Test
    void getUser() {
        User user = userService.getUser("13951905171");
        log.info(String.valueOf(user));
    }

    @Test
    void phoneLogin() {
        PhoneLoginDto phoneLoginDto = PhoneLoginDto.builder().phone("13951905171").code("123456").build();
        boolean b = userService.phoneLogin(phoneLoginDto);
        System.out.println(b);
        //https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/8.jpg
    }

    @Test
    void updateUser() {
        User user = User.builder()
                .phone("13951905171")
                .password(DigestUtils.md5Hex("123123"))
                .nickname("mqxu")
                .avatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/1.jpg")
                .gender(Gender.secret.type)
                .birthday(LocalDate.of(1990, 10, 24))
                .address("江苏宜兴")
                .build();
        userService.updateUser(user);
    }
}