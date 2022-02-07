package com.devoria.stockoria.controllers;

import com.devoria.stockoria.data.item.ItemDto;
import com.devoria.stockoria.data.price.PriceDto;
import com.devoria.stockoria.models.Item;
import com.devoria.stockoria.models.Price;
import com.devoria.stockoria.services.data.ItemService;
import com.devoria.stockoria.services.data.PriceService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item create(@RequestBody ItemDto itemDto, HttpServletRequest req) {
        return this.itemService.create(itemDto, req);
    }

    @GetMapping
    public List<Item> get(HttpServletRequest req) {
        return this.itemService.findAll(req);
    }


}
