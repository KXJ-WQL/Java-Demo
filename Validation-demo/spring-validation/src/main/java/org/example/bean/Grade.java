package org.example.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * @projectName: spring-validation
 * @package: org.example.bean
 * @className: Grade
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/11 20:14
 * @version: v1.0
 */
public class Grade {

    @AssertTrue
    private Boolean no;

    public Grade(Boolean no) {
        this.no = no;
    }
}
