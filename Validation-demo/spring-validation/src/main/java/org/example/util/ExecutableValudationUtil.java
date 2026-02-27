package org.example.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @projectName: spring-validation
 * @package: org.example.util
 * @className: executableValudationUtil
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/12 19:44
 * @version: v1.0
 */
public class ExecutableValudationUtil {

    //普通效验对象
    private static Validator validator;
    //效验入参和返回值对象
    private static ExecutableValidator executableValidator;

    static {
        //获取默认效验对象
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        //提供默认效验对象获取入参和返回值效验对象
        executableValidator = validator.forExecutables();
    }

    public static <T> List<String> validNotBean(T object, Method method, Object[] paramterValues, Class<?>... groups){

        //validateParameters(...)参数效验方法
        Set<ConstraintViolation<T>> constraintViolations = executableValidator.validateParameters(object, method, paramterValues, groups);
        List<String> collect = constraintViolations.stream()
                .map(v -> "属性-" + v.getPropertyPath() + "<->属性值-" + v.getInvalidValue() + "<->效验不通过的信息: " + v.getMessage())
                .collect(Collectors.toList());
        return collect;
    }
}
