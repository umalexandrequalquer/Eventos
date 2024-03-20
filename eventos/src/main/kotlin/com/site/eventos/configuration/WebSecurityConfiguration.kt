package com.site.eventos.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

    fun configuration(http:HttpSecurity){
        http.httpBasic()
    }
@Bean
fun userDetailsService():UserDetailsService{

        var details =  User.withDefaultPasswordEncoder()
            .username("Alexandre")
            .password("996311")
            .roles("USER")
            .build()
    return InMemoryUserDetailsManager(details)
        }

}