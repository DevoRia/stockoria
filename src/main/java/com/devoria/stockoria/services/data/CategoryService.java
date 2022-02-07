package com.devoria.stockoria.services.data;

import com.devoria.stockoria.data.category.CategoryDto;
import com.devoria.stockoria.data.fund.FundDto;
import com.devoria.stockoria.models.Category;
import com.devoria.stockoria.models.Fund;
import com.devoria.stockoria.models.User;
import com.devoria.stockoria.repositories.CategoryRepository;
import com.devoria.stockoria.repositories.FundRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final UserService userService;

    public CategoryService(CategoryRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Category create(CategoryDto categoryDto, HttpServletRequest request) {

        User currentUser = this.userService.getCurrentUser(request);
        Category fund = Category
                .builder()
                .name(categoryDto.getName())
                .fund(categoryDto.getFund())
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .user(currentUser)
                .build();

        return this.repository.save(fund);
    }

    public List<Category> findAll(HttpServletRequest request) {
        User currentUser = this.userService.getCurrentUser(request);
        return this.repository.findAllByUser(currentUser.getId().toHexString());
    }

}
