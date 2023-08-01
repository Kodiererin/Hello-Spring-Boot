package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }

    /////////////////// This was for the Preefined Database Table

//    1. Add support for JDBC and no more Hardcoded users.
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//
//        return  new JdbcUserDetailsManager(dataSource);
//    }



//    //////////////// This is for the userdefined Database Table ///////////////////

        @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

//      Define query to retrieve user by name
            jdbcUserDetailsManager.setUsersByUsernameQuery(
                    "select user_id,pw,active from members where user_id=?"
//                    pw is the password
            );

            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                    "select user_id, role from roles where user_id=?"
            );


//            Remember user id will be given by the user.

//      define query to retrieve the authorities/roles by username.



        return  new JdbcUserDetailsManager(dataSource);
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employee").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        //    Use HTTP basic Authenticationss
        httpSecurity.httpBasic(Customizer.withDefaults());


//       Disable Cross site Request Forgery (CSRF)
//        You can and cannot disable CSIF.
        httpSecurity.csrf(csrf -> csrf.disable());


        return httpSecurity.build();
    }
}
