package com.example.sportmanagementsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        return http.csrf().disable()
                .authorizeHttpRequests()


                .requestMatchers(HttpMethod.GET,"/events/**" ).permitAll()
                .requestMatchers(HttpMethod.GET,"/organizations/**" ).permitAll()
                .requestMatchers(HttpMethod.GET,"/participants/**" ).permitAll()
                .requestMatchers(HttpMethod.GET,"/users/**" ).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/users/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/users/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.PATCH,"/users/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/participants/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/participants/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.PATCH,"/participants/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/organizations/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/organizations/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.PATCH,"/organizations/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/events/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/events/**").authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.PATCH,"/events/**").authenticated()
                .and().formLogin()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
