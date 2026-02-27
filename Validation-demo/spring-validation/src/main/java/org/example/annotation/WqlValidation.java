package org.example.annotation;

import org.example.custom.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @projectName: spring-validation
 * @package: org.example.annotation
 * @className: WqlValidation
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/11 21:01
 * @version: v1.0
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = customValidation.class)
public @interface WqlValidation {
    //提示信息
    String message() default "数字只能为100、101";

    //效验分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };
}
