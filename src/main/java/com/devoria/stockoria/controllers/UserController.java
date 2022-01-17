package com.devoria.stockoria.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUserName(HttpServletRequest req) {
        return req.getUserPrincipal().getName();
    }

}
