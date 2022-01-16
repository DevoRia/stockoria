package com.devoria.stockoria.migrations;

import com.devoria.stockoria.models.Currency;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id="AddCurrencies", order = "1", author = "Vadym", systemVersion = "1")
public class AddCurrencies {

    private final MongoTemplate template;

    public AddCurrencies(MongoTemplate template) {
        this.template = template;
    }

    @Execution
    public void migrationMethod() {
        Currency grivna = Currency.builder()
                .name("grivna")
                .code("UAH")
                .symbol("₴")
                .build();

        template.save(grivna);

        Currency dollar = Currency.builder()
                .name("dollar")
                .code("USD")
                .symbol("$")
                .build();

        template.save(dollar);

        Currency euro = Currency.builder()
                .name("euro")
                .code("EUR")
                .symbol("€")
                .build();

        template.save(euro);
    }

    @RollbackExecution
    public void rollback() {
    }

}