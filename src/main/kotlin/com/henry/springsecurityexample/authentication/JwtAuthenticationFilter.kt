package com.henry.springsecurityexample.authentication

import com.henry.springsecurityexample.authorization.AuthorizationRole
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        // TODO: Implement jwt encryption & decryption.

        SecurityContextHolder.getContext().authentication =
            JwtAuthentication("account", "userName", setOf(AuthorizationRole.MASTER))

        filterChain.doFilter(request, response)
    }
}
