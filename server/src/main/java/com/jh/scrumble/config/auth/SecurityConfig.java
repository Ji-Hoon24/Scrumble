package com.jh.scrumble.config.auth;

import com.jh.scrumble.user.domain.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable();
        http.authorizeRequests().antMatchers("/css/**").permitAll();
        http.authorizeRequests().antMatchers("/images/**").permitAll();
        http.authorizeRequests().antMatchers("/js/**").permitAll();
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.authorizeRequests().antMatchers("/swagger").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui/index.html").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui/**").permitAll();
        http.authorizeRequests().antMatchers("/swagger-ui**").permitAll();
//        http.authorizeRequests().antMatchers("/**").hasRole(Role.USER.name()).anyRequest().authenticated();
        http.logout().logoutSuccessUrl("/").and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
