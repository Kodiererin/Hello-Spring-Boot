package com.Ujjwal.SpringDemo.MVC.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode , String> {
    private String courseCode;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        courseCode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = theCode.startsWith(courseCode);
        return result;
//        this was out our Logic.

    }


}
