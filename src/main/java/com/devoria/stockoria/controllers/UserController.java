package com.devoria.stockoria.controllers;

import com.devoria.stockoria.models.Login;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class UserController {

    @GetMapping("/health")
    public HttpStatus health() {
        return OK;
    }


    @GetMapping("/api/user")
    public String getInfo(HttpServletRequest req) {
        return "HelloU";
    }

}
