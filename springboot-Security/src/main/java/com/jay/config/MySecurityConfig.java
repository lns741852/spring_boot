package com.jay.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");       //加密

        auth                                     //認證帳密，若無配置configure方法，瀏覽任URL都需密碼
                .inMemoryAuthentication()
                .withUser("admin")
                .password(password)
                .roles("VIP1", "VIP2");*/

        auth.userDetailsService(userDetailsService).passwordEncoder(passowrd());
    }

    @Bean
    PasswordEncoder passowrd(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1");                 //URL授權
                                                        //hasAuthority("VIP1")
                                                        //hasAynAuthority("VIP1","VIP2)
        http.formLogin()
                .usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin")    //啟動授權，並接收參數
                //若直接登入用.loginProcessingUrl("/pages/login")，使用超連結到登入頁要用controller
                .defaultSuccessUrl("/")
                .and().rememberMe().rememberMeParameter("remeber");

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.exceptionHandling().accessDeniedPage("/unauth.html");          //無權限時跳轉

    }



}
