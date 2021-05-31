package com.henry.springsecurityexample.handler

import mu.KLogging
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAccessDeniedHandler: AccessDeniedHandler {
    companion object: KLogging()

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        exception: AccessDeniedException
    ) {
        logger.debug("Access Denied: ${exception.message}")

        response.status = HttpServletResponse.SC_FORBIDDEN
    }
}
