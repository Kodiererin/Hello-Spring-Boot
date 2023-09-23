package com.ujjwal.AOPDemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipImplDAO implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass()+" : Doint my DB Work : Adding an Membership Account");
    }
}
