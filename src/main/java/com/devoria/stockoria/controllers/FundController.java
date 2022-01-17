package com.devoria.stockoria.controllers;

import com.devoria.stockoria.data.fund.FundDto;
import com.devoria.stockoria.models.Fund;
import com.devoria.stockoria.services.data.FundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class FundController {

    private final FundService fundService;

    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @PostMapping("/fund")
    public Fund create(@RequestBody FundDto fundDto, HttpServletRequest req) {
        return this.fundService.create(fundDto, req);
    }

    @GetMapping("/fund")
    public List<Fund> get(HttpServletRequest req) {
        return this.fundService.findAll(req);
    }

}
