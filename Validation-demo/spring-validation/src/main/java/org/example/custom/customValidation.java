package org.example.custom;

import org.example.annotation.WqlValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: spring-validation
 * @package: org.example.custom
 * @className: customValidation
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/11 21:04
 * @version: v1.0
 */
public class customValidation implements ConstraintValidator<WqlValidation, Integer> {

    @Override
    public void initialize(WqlValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if( value == null ){
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(100);
        set.add(101);
        //值只能属于100和101
        return set.contains(value);
    }
}
