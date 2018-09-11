package com.webapp.configuration;


import com.webapp.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.*;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@ComponentScan("com.webapp")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
            .authorizeRequests()
                .antMatchers("/resources/**","/webjars/**")
                .permitAll()
                .antMatchers("/login")
                .anonymous()
                .anyRequest()
                .authenticated()
            .and()
            .formLogin()
            .loginPage("/login").permitAll()
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/login.html");
//        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll()
//        .anyRequest().permitAll();
       // http.authorizeRequests().antMatchers("/resources/**").permitAll();



    }
}
