package com.henry.springsecurityexample.authentication

import com.henry.springsecurityexample.authorization.AuthorizationRole
import org.springframework.security.authentication.AbstractAuthenticationToken

data class JwtAuthentication(
    val account: String,
    val userName: String,
    val roles: Collection<AuthorizationRole>
) : AbstractAuthenticationToken(roles) {

    override fun getCredentials(): Any? {
        return null
    }

    override fun getPrincipal(): Any {
        return Pair(account, userName)
    }
}
