package com.example.AndroidAPIServer.config;

import com.example.AndroidAPIServer.jwt.JwtAccessDeniedHandler;
import com.example.AndroidAPIServer.jwt.JwtAuthenticationEntryPoint;
import com.example.AndroidAPIServer.jwt.JwtSecurityConfig;
import com.example.AndroidAPIServer.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity  //기본적인 웹 보안 활성화
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvier;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(
                        "/h2-console/**"
                        ,"/favicon.ico"
                        ,"/error"
                );
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // token을 사용하는 방식이기 때문에 csrf를 disable
                .csrf().disable()
                .exceptionHandling()
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)

                // enable h2-console
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                // 세션을 사용하지 않기 때문에 STATELESS로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()//접근 제한 설정
                .antMatchers("/mobileServer/**/**").permitAll()
                .antMatchers("/api//auth/authenticate").permitAll()
                .antMatchers("/api/user/signup").permitAll()
                .antMatchers("/api/image/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated()  //위 세 url 이외에는 모두 인증이 필요함

                //앞서 구현한 토큰 인증을 위한 JwtSecurityConfig 적용
                .and()
                .apply(new JwtSecurityConfig(tokenProvier));



    }
}