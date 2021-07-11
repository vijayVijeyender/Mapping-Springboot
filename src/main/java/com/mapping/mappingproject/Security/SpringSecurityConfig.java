package com.mapping.mappingproject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("admin");
        auth.inMemoryAuthentication().withUser("vijay").password("pass").roles("user");
    
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
       
        
         http.authorizeRequests().antMatchers("/Employee/**").authenticated().
         anyRequest().authenticated()
         .and().httpBasic().and()
         .formLogin().permitAll()
         .and().csrf().disable();
            
    }

@Bean
public static NoOpPasswordEncoder passordEncoder(){
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    
}

    
}
    

