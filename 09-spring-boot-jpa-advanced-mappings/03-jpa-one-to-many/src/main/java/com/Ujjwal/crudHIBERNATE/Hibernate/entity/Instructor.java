package com.Ujjwal.crudHIBERNATE.Hibernate.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//    Annotate the class as an eitity and map it to database table
//    As it the second table so we also have to set up mapping to InstructorDetail entity
@Entity
@Table(name = "instructor")
public class Instructor {

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "instructor_detail_id")
        private InstructorDetail instructorDetail;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private  int id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

    public Instructor() {
    }

//    @OneToMany(mappedBy = "instructor" ,fetch = FetchType.EAGER, cascade = {CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH , CascadeType.PERSIST})

    @OneToMany(mappedBy = "instructor" ,fetch = FetchType.LAZY, cascade = {CascadeType.MERGE , CascadeType.DETACH , CascadeType.REFRESH , CascadeType.PERSIST})
//    this is mapping to the variable name so, be careful by your napimg.

    private List<Course> courses;

//    Add convenience methods for bi-directional relationships

    public void add(Course tempCourse){

        if(courses==null)
            courses = new ArrayList<>();
        courses.add(tempCourse);

        tempCourse.setInstructor(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Instructor(String firstName, String lastName, String email) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
        }

        public InstructorDetail getInstructorDetail() {
                return instructorDetail;
        }

        public void setInstructorDetail(InstructorDetail instructorDetail) {
                this.instructorDetail = instructorDetail;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }


        @Override
        public String toString() {
                return "Instructor{" +
                        "instructorDetail=" + instructorDetail +
                        ", id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
