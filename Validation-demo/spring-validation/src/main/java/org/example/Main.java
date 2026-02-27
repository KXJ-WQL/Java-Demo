package org.example;

import org.example.bean.Grade;
import org.example.bean.UserInfo;
import org.example.service.UserInfoService;
import org.example.util.ValidationUtil;

import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @projectName: ${PROJECT_NAME}
 * @package: org.example
 * @className: ${NAME}
 * @author: WQL-KXJ
 * @description: TODO
 * @date: ${DATE} ${TIME}
 * @version: v1.0
 */
public class Main {
    public static void mains(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("wql");
        userInfo.setSex("男1");
        userInfo.setAge(190);
        userInfo.setEmail("2562694007@qq.com");
        userInfo.setPhone("15526446827");
        userInfo.setBirthDay(LocalTime.from(LocalDateTime.now().minusDays(1)));
        userInfo.setGrade(new Grade(true));
        userInfo.setCustomInt(200);
        //新增分组效验
        List<String> valid1 = ValidationUtil.valid(userInfo,UserInfo.Add.class, Default.class);
        //修改分组效验
        //List<String> valid2 = ValidationUtil.valid(userInfo,UserInfo.Update.class, Default.class);
        System.out.println(valid1.toString());
    }

    public static void main(String[] args) {
        UserInfoService userInfoService = new UserInfoService();
        userInfoService.getByName(null);
    }
}