package com.henry.springsecurityexample.security

import org.springframework.security.authentication.AbstractAuthenticationToken

data class JwtAuthentication(
    val account: String,
    val userName: String
) : AbstractAuthenticationToken(null) {

    override fun getCredentials(): Any? {
        return null
    }

    override fun getPrincipal(): Any {
        return Pair(account, userName)
    }
}
