package com.ujjwal.AOPDemo.dao;

import com.ujjwal.AOPDemo.Account;

public interface AccountDAO {
//    void addAccount();
//    void addUjjwalMember();

//    void addAccount(Account theAccount);
void addAccount(Account theAccount , boolean vipFlag);

void helloUjjwal();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode) ;

}
