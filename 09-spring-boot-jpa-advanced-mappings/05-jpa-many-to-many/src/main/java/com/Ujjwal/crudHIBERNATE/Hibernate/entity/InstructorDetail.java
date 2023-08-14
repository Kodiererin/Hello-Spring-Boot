package com.Ujjwal.crudHIBERNATE.Hibernate.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//    Annoatte the class as an entity and map to db table

@Entity
@Table(name = "instructor_detail")

public class InstructorDetail {



//    Define the fields
//    Annotate the fields with db column names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    @OneToOne(mappedBy = "instructorDetail" , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
//    cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH}
//    We added CascadeType all functions by not remove because we dont want to remove the InstructorDetail
//    So we added InstructorDetail so that It is not removed.
//    This instructorDetail must be same in the Variable name.
    private Instructor instructor;


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    //    Create constructors


    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    //    Generate Getters and Setters methods.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


//    Generate toString methods


    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }


}

