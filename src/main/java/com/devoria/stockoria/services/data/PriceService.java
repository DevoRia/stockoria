package com.devoria.stockoria.services.data;

import com.devoria.stockoria.data.category.CategoryDto;
import com.devoria.stockoria.data.price.PriceDto;
import com.devoria.stockoria.models.Category;
import com.devoria.stockoria.models.Price;
import com.devoria.stockoria.models.User;
import com.devoria.stockoria.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository repository;
    private final UserService userService;

    public PriceService(PriceRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Price create(PriceDto priceDto, HttpServletRequest request) {

        User currentUser = this.userService.getCurrentUser(request);
        Price fund = Price
                .builder()
                .value(priceDto.getValue())
                .priceCategory(priceDto.getPriceCategory())
                .currency(priceDto.getCurrency())
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .user(currentUser)
                .build();

        return this.repository.save(fund);
    }

    public List<Price> findAll(HttpServletRequest request) {
        User currentUser = this.userService.getCurrentUser(request);
        return this.repository.findAllByUser(currentUser.getId().toHexString());
    }
}
