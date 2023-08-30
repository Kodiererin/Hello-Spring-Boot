package com.ujjwal.AOPDemo.dao;


import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import com.ujjwal.AOPDemo.Account;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount , boolean theVIP) {
        System.out.println(getClass()+" : Doint my DB Work : Adding an Account");
    }

    @Override
    public void helloUjjwal() {
        System.out.println("Hello Ujjwal How Are You!");
    }


    public String getName() {
        System.out.println(getClass()+" Do Work");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" Do Work");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" Do Work");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" Do Work");
        this.serviceCode = serviceCode;
    }
}
