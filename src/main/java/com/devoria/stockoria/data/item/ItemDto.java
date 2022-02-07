package com.devoria.stockoria.data.item;

import com.devoria.stockoria.models.Category;
import com.devoria.stockoria.models.Currency;
import com.devoria.stockoria.models.Fund;
import com.devoria.stockoria.models.Price;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String name;
    private Fund fund;
    private Category category;
    private List<Price> prices;
    private Currency currency;
}
