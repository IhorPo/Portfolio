package com.restapi.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // adding basic auth
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        // giving access only to the users
                        .antMatchers("/shop/users/*")
                        .hasRole(AppUserRole.USER.name())
                        // giving access only to the admin
                        .antMatchers("/shop/**")
                        .hasRole(AppUserRole.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    // Unlock access to some pages without previous login (white list)
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/","/shop","index","/css/*","/js/*");
    }

    // For retrieve users from database
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // admin user
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(AppUserRole.ADMIN.name())
                .build();

        // default users
        UserDetails user = User.builder()
                .username("Ihor")
                .password(passwordEncoder.encode("ihor12345"))
                .roles(AppUserRole.USER.name()) // ROLE_USER
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

}
