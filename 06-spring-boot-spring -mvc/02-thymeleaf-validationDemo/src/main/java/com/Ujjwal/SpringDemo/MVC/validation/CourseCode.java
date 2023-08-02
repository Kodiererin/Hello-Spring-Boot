package com.Ujjwal.SpringDemo.MVC.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// THis means Retain this code during the runtime and add this to byte code.
public @interface CourseCode {
//    Define default course code
    public String value() default "LUV";
//    Define.efault error message
    public String message() default "Must Start with LUV";
//    define default groups
    public Class<?>[] groups() default {};
//    Define default paylods
    public Class <? extends Payload>[] payload() default{};

}
