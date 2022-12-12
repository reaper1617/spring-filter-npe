package com.gerasimchuk.samplefilter.custom_once_per_request_filter.config;

import com.gerasimchuk.samplefilter.custom_once_per_request_filter.filter.SampleFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final SampleFilter sampleFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(
                     c -> c.requestMatchers("/**").permitAll()
                )
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement(
                        c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(sampleFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
