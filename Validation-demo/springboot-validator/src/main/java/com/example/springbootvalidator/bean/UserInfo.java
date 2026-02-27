package com.example.springbootvalidator.bean;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import java.time.LocalTime;

/**
 * @projectName: spring-validation
 * @package: org.example.bean
 * @className: UserInfo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/11 16:00
 * @version: v1.0
 */
public class UserInfo {

//    //定义新增分组
//    public interface Add{}
//
//    //定义修改分组
//    public interface Update{}
//
//    @Null(groups = {Add.class})//只适用于新增
//    @NotNull(groups = {Update.class})//只适用于修改
//    private Long id;

    @NotBlank(message = "名称不能为空") //不能为null, 而且调用trim()后, 长度必须大于0
    private String name;

    @NotEmpty //不为空且长度必须大于0
    @Size(max = 1,message = "最多{max}个字符")//字符串长度只能为1
    private String sex;

    @NotNull//不为空
    @Range(min = 1,max = 150)//值的范围只能在1~150之间
    private Integer age;

    @Email //只能是邮箱格式
    private String email;

    @NotEmpty
    @Pattern(regexp = "(\\d{3,4}-\\d{7,8})|(1[3-9]\\d{9})")
    private String phone;

    @Past //必须是过去的日期
    private LocalTime birthDay;

    public UserInfo(){}

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalTime birthDay) {
        this.birthDay = birthDay;
    }

}
