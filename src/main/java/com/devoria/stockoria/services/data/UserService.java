package com.devoria.stockoria.services.data;

import com.devoria.stockoria.models.User;
import com.devoria.stockoria.repositories.FundRepository;
import com.devoria.stockoria.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getCurrentUser(HttpServletRequest req) {
        String name = req.getUserPrincipal().getName();
        return this.repository.findUserByUsername(name);
    }


}
