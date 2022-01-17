package com.devoria.stockoria.services.data;

import com.devoria.stockoria.models.Currency;
import com.devoria.stockoria.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;
    private final CurrencyRepository repository;

    @Value("${com.stockoria.third-party.currency-api}")
    private String currencyConverterEndpoint;

    public CurrencyService(RestTemplateBuilder restTemplateBuilder, CurrencyRepository repository) {
        this.restTemplate = restTemplateBuilder.build();
        this.repository = repository;
    }

    public Double getCurrencyPriceRelatively(Currency target, Currency relative) {
        String customizedEndpoint = this.currencyConverterEndpoint.replace("{from}", relative.getCode()).replace("{to}", target.getCode());
        HashMap<String, Double> result = this.restTemplate.getForObject(customizedEndpoint, HashMap.class);
        if (result != null) {
            return (Double) result.values().toArray()[0];
        }
        return 1.0;
    }

    public List<Currency> findAll() {
        return this.repository.findAll();
    }

    public Currency findCurrencyByCode(String code) {
        return this.repository.findCurrencyByCode(code);
    }

}
