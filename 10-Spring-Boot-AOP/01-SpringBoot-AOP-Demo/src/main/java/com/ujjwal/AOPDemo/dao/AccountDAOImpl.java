package com.ujjwal.AOPDemo.dao;


import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import com.ujjwal.AOPDemo.Account;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

//    @Override
//    public void addAccount() {
//        System.out.println(getClass()+" : Doint my DB Work : Adding an Account");
//    }



//    @Override
//    public void addAccount(Account theAccount) {
//        System.out.println(getClass()+" : Doint my DB Work : Adding an Account");
//    }
    @Override
    public void addAccount(Account theAccount , boolean theVIP) {
        System.out.println(getClass()+" : Doint my DB Work : Adding an Account");
    }

    @Override
    public void helloUjjwal() {
        System.out.println("Hello Ujjwal How Are You!");
    }

//    @Override
//    public void addUjjwalMember() {
//        System.out.println("===> Hello This is Ujjwal <======");
//    }

//    @Override
//    public void addAccount() {
//        System.out.println("Hello World");
//    }
}
