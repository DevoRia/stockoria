package com.devoria.stockoria.controllers;

import com.devoria.stockoria.data.price.PriceDto;
import com.devoria.stockoria.models.Price;
import com.devoria.stockoria.services.data.PriceService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    public Price create(@RequestBody PriceDto priceDto, HttpServletRequest req) {
        return this.priceService.create(priceDto, req);
    }

    @GetMapping
    public List<Price> get(HttpServletRequest req) {
        return this.priceService.findAll(req);
    }

}
