package com.example.Monuments.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers( "/","/catalog","/list","/getListMonuments","/Constructor","/GetImage","/GetCatalogImage","/css/**","/images/**","/scripts/**").permitAll()
                    .antMatchers(HttpMethod.POST,"/reg","/add_task").permitAll()
                    .antMatchers(HttpMethod.POST, "/xv").hasAuthority("ADMIN")
                    .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .csrf().disable()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select login, password,active from usr where login=?")
                .authoritiesByUsernameQuery("select login, role from usr where login=?");
    }
}