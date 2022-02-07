package com.devoria.stockoria.services.data;

import com.devoria.stockoria.data.item.ItemDto;
import com.devoria.stockoria.data.price.PriceDto;
import com.devoria.stockoria.models.Item;
import com.devoria.stockoria.models.Price;
import com.devoria.stockoria.models.User;
import com.devoria.stockoria.repositories.ItemRepository;
import com.devoria.stockoria.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;
    private final UserService userService;

    public ItemService(ItemRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Item create(ItemDto itemDto, HttpServletRequest request) {

        User currentUser = this.userService.getCurrentUser(request);
        Item fund = Item
                .builder()
                .currency(itemDto.getCurrency())
                .fund(itemDto.getFund())
                .category(itemDto.getCategory())
                .prices(itemDto.getPrices())
                .name(itemDto.getName())
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .user(currentUser)
                .build();

        return this.repository.save(fund);
    }

    public List<Item> findAll(HttpServletRequest request) {
        User currentUser = this.userService.getCurrentUser(request);
        return this.repository.findAllByUser(currentUser.getId().toHexString());
    }
}
