package com.mqxu.vlog.controller;

import com.mqxu.vlog.common.ResponseResult;
import com.mqxu.vlog.common.ResultCode;
import com.mqxu.vlog.exception.CustomException;
import com.mqxu.vlog.model.dto.*;
import com.mqxu.vlog.model.entity.User;
import com.mqxu.vlog.service.RedisService;
import com.mqxu.vlog.service.UserService;
import com.mqxu.vlog.util.FileResource;
import com.mqxu.vlog.util.SmsUtil;
import com.mqxu.vlog.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description: 用户Controller
 * @author: mqxu
 * @create: 2020-12-05 14:36
 **/
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private SmsUtil smsUtil;
    @Resource
    private RedisService redisService;
    @Resource
    private FileResource fileResource;

    //@GetMapping(value = "/get")
    //public User getUser(String phone) {
    //    User user = userService.getUser(phone);
    //    if (user == null) {
    //        throw new NullPointerException();
    //    }
    //    return user;
    //}

    @GetMapping(value = "{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new NullPointerException();
        }
        return user;
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody LoginDto loginDto) {
        log.info("loginDto:" + loginDto);
        boolean flag = userService.login(loginDto);
        if (flag) {
            return userService.getUser(loginDto.getPhone());
        } else {
            throw new CustomException("登录失败", ResultCode.USER_SIGN_IN_FAIL);
        }
    }

    @PostMapping(value = "/sendcode")
    public ResponseResult sendCode(@RequestParam String phone) {
        //随机验证码
        String code = StringUtil.getVerifyCode();
        System.out.println(code);
        //给入参手机号发送短信
        boolean flag = smsUtil.sendSms(phone, code);
        redisService.set(phone, code, 1L);
        if (flag) {
            //验证码存入redis，1分钟有效
            return ResponseResult.success(code);
        } else {
            return ResponseResult.failure(ResultCode.SMS_ERROR);
        }
    }

    @PostMapping(value = "/phonelogin")
    public User phonelogin(@RequestBody PhoneLoginDto phoneLoginDto) {
        log.info("phoneLoginDto:" + phoneLoginDto);
        boolean flag = userService.phoneLogin(phoneLoginDto);
        if (flag) {
            return userService.getUser(phoneLoginDto.getPhone());
        } else {
            throw new CustomException("验证码错误", ResultCode.USER_VERIFY_CODE_ERROR);
        }
    }

    @PostMapping(value = "/captchaLogin")
    public User captchaLogin(@RequestBody CaptchaLoginDto captchaLoginDto) {
        log.info("captchaLoginDto:" + captchaLoginDto);
        User user = userService.captchaLogin(captchaLoginDto);
        if (user == null) {
            throw new CustomException("登录失败", ResultCode.USER_SIGN_IN_FAIL);
        }
        return user;
    }


    @PostMapping(value = "/update")
    public User update(@RequestBody User user) {
        log.info("user:" + user);
        return userService.updateUser(user);
    }

    @PostMapping(value = "/upload")
    public ResponseResult uploadFile(MultipartFile file) {
        // 声明图片的地址路径，返回到前端
        String path = null;
        // 判断文件不能为空
        if (file != null) {
            // 获得文件上传的名称
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            //调用上传服务，得到上传后的新文件名
            path = userService.uploadFile(file);
        }
        if (StringUtils.isNotBlank(path)) {
            //拼接上服务器地址前缀，得到最终返回给前端的url
            path = fileResource.getOssHost() + path;
        }
        return ResponseResult.success(path);
    }

}