package com.devoria.stockoria.services.data;

import com.devoria.stockoria.StockoriaApplication;
import com.devoria.stockoria.repositories.CurrencyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockoriaApplication.class)
@AutoConfigureMockMvc
public class CurrencyServiceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CurrencyRepository repository;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

    }
}
