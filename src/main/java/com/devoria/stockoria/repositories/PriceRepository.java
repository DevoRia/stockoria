package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Category;
import com.devoria.stockoria.models.Price;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PriceRepository extends MongoRepository<Price, ObjectId> {
    @Query("{ 'user' : ObjectId('?0') }")
    List<Price> findAllByUser(String userId);
}
