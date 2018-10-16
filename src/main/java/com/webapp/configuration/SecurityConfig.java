package com.webapp.configuration;


import com.webapp.security.AuthFailure;
import com.webapp.security.AuthSuccess;
import com.webapp.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.servlet.*;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@ComponentScan("com.webapp")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userService;

    @Autowired
    private AuthFailure authFailure;

    @Autowired
    private AuthSuccess authSuccess;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/resources/**","/webjars/**","/sessiondetails/**")
                .permitAll()
                .antMatchers("/login**","/registry**","/register**")
                .anonymous()
                .anyRequest()//.permitAll()
                .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
                .successHandler(authSuccess)
            //.defaultSuccessUrl("/",true)
            //.failureUrl("/login?error=true")
                .failureHandler(authFailure)
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/login.html")
        .and()
        .csrf().disable();


//        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**").permitAll()
//        .anyRequest().permitAll();
       // http.authorizeRequests().antMatchers("/resources/**").permitAll();



    }
}
