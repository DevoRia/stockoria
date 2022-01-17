package com.devoria.stockoria.data.currency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvertCurrencyDto {
    private String target;
    private String relative;
}
