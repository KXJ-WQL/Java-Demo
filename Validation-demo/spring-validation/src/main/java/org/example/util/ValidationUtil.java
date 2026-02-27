package org.example.util;

import org.example.bean.UserInfo;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @projectName: spring-validation
 * @package: org.example.util
 * @className: ValidationUtil
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/11 15:57
 * @version: v1.0
 */
public class ValidationUtil {

    //线程安全
    private static Validator validator;

    //快速失败failfast
    private static Validator failFastValidator;

    //代码块初始话
    static {
        //获取validation效验对象
        validator =  Validation.buildDefaultValidatorFactory().getValidator();

        //获取快速失败对象
        failFastValidator = Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true)//快速失败
                .buildValidatorFactory().getValidator();
    }

    //效验方法
    public static List<String> valid(UserInfo userInfo,Class<?>... groups){

        //如果被效验对象没有效验通过获取效验信息
        Set<ConstraintViolation<UserInfo>> validate = failFastValidator.validate(userInfo,groups);
        List<String> collect = validate.stream()
                .map(v -> "属性-" + v.getPropertyPath() + "<->属性值-" + v.getInvalidValue() + "<->效验不通过的信息: " + v.getMessage())
                .collect(Collectors.toList());
        return collect;
    }

}
