package com.devoria.stockoria.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.HttpStatus.OK;

public class CommonController {

    @GetMapping("/health")
    public HttpStatus health() {
        return OK;
    }

}
