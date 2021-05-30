package com.henry.springsecurityexample.test

import com.henry.springsecurityexample.authentication.JwtAuthentication
import com.henry.springsecurityexample.authorization.AuthorizationRole
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
@Secured(AuthorizationRole.Code.MASTER)
class TestController {

    companion object : KLogging()

    @GetMapping
    fun test(): ResponseEntity<String> {
        val context = SecurityContextHolder.getContext()
        val jwtAuthentication = context.authentication as JwtAuthentication

        logger.info("TEST API LOG")
        logger.info("account: ${jwtAuthentication.account}, userName: ${jwtAuthentication.userName}, roles: ${jwtAuthentication.authorities}")

        return ResponseEntity.ok("TEST OK!")
    }
}
