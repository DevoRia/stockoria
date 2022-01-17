package com.devoria.stockoria.services.data;

import com.devoria.stockoria.data.fund.FundDto;
import com.devoria.stockoria.models.Fund;
import com.devoria.stockoria.models.User;
import com.devoria.stockoria.repositories.FundRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class FundService {

    private final FundRepository repository;
    private final UserService userService;

    public FundService(FundRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Fund create(FundDto fundDto, HttpServletRequest request) {

        User currentUser = this.userService.getCurrentUser(request);
        Fund fund = Fund
                .builder()
                .name(fundDto.getName())
                .createdDate(new Date())
                .lastModifiedDate(new Date())
                .user(currentUser)
                .build();

        return this.repository.save(fund);
    }

}
