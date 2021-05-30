package com.henry.springsecurityexample.test

import com.henry.springsecurityexample.security.JwtAuthentication
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    companion object : KLogging()

    @GetMapping
    fun test(): ResponseEntity<String> {
        val context = SecurityContextHolder.getContext()
        val jwtAuthentication = context.authentication as JwtAuthentication

        logger.info("account: ${jwtAuthentication.account}, userName: ${jwtAuthentication.userName}")

        return ResponseEntity.ok("TEST OK!")
    }
}
