package com.kxjsecurity.service;

import com.kxjsecurity.dao.userDao;
import com.kxjsecurity.pojo.SecurityUserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.service
 * @Date 2022/8/14 16:49
 * @Version 1.0
 */
@SpringBootTest
public class BcryptTest {

    @Autowired
    userDao userDao;

    @Test
    public void bcrypt(){

        //对密码进行加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());

        System.out.println(hashpw);

        //效验
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$YBCz.XizDGJcN.2SGqNQuOf/U.yN4ku6rC8zDgKfHxuDAz8guOkby");
        System.out.println(checkpw);
    }

    @Test
    public  void h(){

        SecurityUserPojo wql = userDao.getUserByUserName("wql");

        System.out.println(wql);

    }

    @Test
    public  void hh(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
        //$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2
    }

}
