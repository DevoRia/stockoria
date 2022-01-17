package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Currency;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CurrencyRepository extends MongoRepository<Currency, ObjectId> {

    @Query("{ 'code' : ?0 }")
    Currency findCurrencyByCode(String code);

}
