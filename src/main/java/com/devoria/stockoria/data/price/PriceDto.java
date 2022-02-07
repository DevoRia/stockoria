package com.devoria.stockoria.data.price;

import com.devoria.stockoria.enums.PriceCategory;
import com.devoria.stockoria.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    private Double value;
    private Currency currency;
    private PriceCategory priceCategory;
}
