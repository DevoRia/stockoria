package com.devoria.stockoria.data.category;

import com.devoria.stockoria.models.Fund;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private String name;
    private Fund fund;
}
