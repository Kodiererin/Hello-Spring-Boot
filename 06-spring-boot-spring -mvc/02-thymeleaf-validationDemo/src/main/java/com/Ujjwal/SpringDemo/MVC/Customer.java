package com.Ujjwal.SpringDemo.MVC;

import com.Ujjwal.SpringDemo.MVC.validation.CourseCode;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;

public class Customer {
    private  String firstName;
    @Size(min = 1)
    @NotNull(message = "LastName is Required")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    @NotNull(message = "Integer Field is Required.")
    @Min(value = 0 , message = "Must Be Greater Than 0")
    @Max(value = 10,message = "Must be Less than or equal to 10")
    private Integer freePasses;


    @NotNull
    @Pattern(regexp = "^[a-zA-z0-9]{5}" , message = "5 Characters Only")
    private String postalCode;


    @NotNull
    public Integer getFreePasses() {
        return freePasses;
    }


    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
