package com.example.lesson.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Collections

@RestController
class HelloController {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloThere(): MutableMap<String, String> {
        return Collections.singletonMap("message", "hey yo")
    }

    @GetMapping("/hello-there")
    fun hello() = "Hello! There"

}