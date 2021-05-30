package com.henry.springsecurityexample.security

import mu.KLogging
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtAuthenticationProvider : AuthenticationProvider {

    companion object : KLogging()

    override fun authenticate(authentication: Authentication): Authentication? {
        // TODO: Implement user DB lookup and authentication using decrypted jwt

        return (authentication as JwtAuthentication).also {
            logger.info("userName = [${it.userName}], account = [${it.account}]")
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication.isAssignableFrom(JwtAuthentication::class.java)
    }
}
