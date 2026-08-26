package com.bitarantech.toobazar.backend.utils.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun SecurityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain{
        return httpSecurity.authorizeHttpRequests {
            it.anyRequest().permitAll()
        }.csrf {
            it.disable()
        }.build()
    }
}
