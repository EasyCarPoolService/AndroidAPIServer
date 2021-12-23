package com.example.AndroidAPIServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.headers().frameOptions().disable();
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/api/user/signup").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("api/user/login").permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

    }



}
