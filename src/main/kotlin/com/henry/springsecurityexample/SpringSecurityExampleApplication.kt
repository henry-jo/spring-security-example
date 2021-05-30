package com.henry.springsecurityexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@EnableGlobalMethodSecurity(
	prePostEnabled = true,
	securedEnabled = true
)
@SpringBootApplication
class SpringSecurityExampleApplication

fun main(args: Array<String>) {
	runApplication<SpringSecurityExampleApplication>(*args)
}
