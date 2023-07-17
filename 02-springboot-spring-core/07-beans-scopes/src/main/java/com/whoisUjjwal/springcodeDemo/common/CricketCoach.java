package com.whoisUjjwal.springcodeDemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements  Coach{

    CricketCoach(){
        System.out.println("Cricket Coach "+this.getClass().getName());
    }
    @Override
    public String getDailyWorkout() {

        return "Practise Bowling..";
    }
}
