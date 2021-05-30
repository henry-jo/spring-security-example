package com.henry.springsecurityexample.authorization

import org.springframework.security.core.GrantedAuthority

enum class AuthorizationRole(
    val label: String,
    private val authorityCode: String
) : GrantedAuthority {
    MASTER("관리자", Code.MASTER),
    USER("유저", Code.USER);

    override fun getAuthority(): String = authorityCode

    object Code {
        const val MASTER = "ROLE_MASTER"
        const val USER = "ROLE_USER"
    }
}
