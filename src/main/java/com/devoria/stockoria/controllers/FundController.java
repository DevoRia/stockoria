package com.devoria.stockoria.controllers;

import com.devoria.stockoria.data.fund.FundDto;
import com.devoria.stockoria.models.Fund;
import com.devoria.stockoria.services.data.FundService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/fund")
public class FundController {

    private final FundService fundService;

    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @PostMapping
    public Fund create(@RequestBody FundDto fundDto, HttpServletRequest req) {
        return this.fundService.create(fundDto, req);
    }

    @GetMapping
    public List<Fund> get(HttpServletRequest req) {
        return this.fundService.findAll(req);
    }

}
