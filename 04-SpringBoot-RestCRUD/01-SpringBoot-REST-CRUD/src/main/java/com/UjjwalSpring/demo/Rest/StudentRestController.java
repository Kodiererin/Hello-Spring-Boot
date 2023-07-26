package com.UjjwalSpring.demo.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.UjjwalSpring.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    List<Student> list = new ArrayList<>();
//    Define endpoint ("/getAll");
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudent(){
        list.add(new Student(1,"Ujjwal","Kumar"));
        list.add(new Student(2,"Kumar","Ujjwal"));
        list.add(new Student(3,"Hello","World"));
        return list;
    }

    @GetMapping("/getAllStudents/{studentId}")
    public Student getStudent(@PathVariable int studentId){
//        check the studentid again list size

        if(studentId<list.size()){
            return list.get(studentId);
        }else{
            throw new StudentNotFoundException("Student Id Not Found "+studentId);
        }
    }


//    Add an Exception Hancler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
//        Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

//        Return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

//    Add another exception Handler.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e2){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e2.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

//        Return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}



