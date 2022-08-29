package com.example.RentingApartments.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    static final String client = "CLIENT";
    static final String renter = "RENTER";

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public JWTRequestFilter authenticationJwtTokenFilter(){
        return new JWTRequestFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.headers().cacheControl().disable();
        httpSecurity.cors();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/auth/login").permitAll()

                .antMatchers(HttpMethod.GET,"/api/advertisements").permitAll()
                .antMatchers(HttpMethod.GET,"/api/advertisements/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/advertisements").hasRole(renter)
                .antMatchers(HttpMethod.POST, "/api/advertisements").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/advertisements/**").permitAll()

                .antMatchers(HttpMethod.GET,"/api/apartments").permitAll()
                .antMatchers(HttpMethod.GET,"/api/apartments/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/apartments/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/apartments/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/apartments").permitAll()

                /*.antMatchers(HttpMethod.GET,"/api/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/**").permitAll()*/

                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
