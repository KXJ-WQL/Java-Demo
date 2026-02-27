package org.example.service;

import org.example.util.ExecutableValudationUtil;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @projectName: spring-validation
 * @package: org.example.service
 * @className: UserInfoService
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/12 20:31
 * @version: v1.0
 */
public class UserInfoService {

    public String getByName(@NotNull String name){
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        //获取方法名称
        String methodName = stackTraceElement.getMethodName();
        Method method = null;

        try {
            //通过反射获取当前方法对象
            method = this.getClass().getDeclaredMethod(methodName,String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<String> list = ExecutableValudationUtil.validNotBean(this, method, new Object[]{name});
        System.out.println(list);
        return "ok";
    }
}
