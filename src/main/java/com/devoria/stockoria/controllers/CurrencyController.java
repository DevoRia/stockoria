package com.devoria.stockoria.controllers;

import com.devoria.stockoria.data.SimpleResponse;
import com.devoria.stockoria.data.currency.ConvertCurrencyDto;
import com.devoria.stockoria.services.data.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency/convert")
    public SimpleResponse convert(@RequestBody ConvertCurrencyDto convertCurrencyDto) {
        Double result = this.currencyService
                .getCurrencyPriceRelatively(convertCurrencyDto.getTarget(), convertCurrencyDto.getRelative());
        return new SimpleResponse(result);
    }

}
