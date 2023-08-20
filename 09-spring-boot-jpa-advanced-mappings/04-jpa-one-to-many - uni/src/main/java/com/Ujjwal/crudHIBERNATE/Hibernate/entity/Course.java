package com.Ujjwal.crudHIBERNATE.Hibernate.entity;


import jakarta.persistence.*;
import  com.Ujjwal.crudHIBERNATE.Hibernate.entity.Review;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

//    Define our fields.
//    Define constructors
//    define getters and setters
//    define toString
//    annotate fields



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    @ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH})
    @JoinTable(
            name = "course_student" ,
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;


//    add a convenience method
    public void addStudent(Student theStudent){
        if(students==null){
            students = new ArrayList<>();
        }students.add(theStudent);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private java.util.List<Review> reviewList;


    public void addReview(Review review){
        if(reviewList==null){
            reviewList = new ArrayList<>();
        }
            reviewList.add(review);
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor= instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}