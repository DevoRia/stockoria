package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Price;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<Price, ObjectId> {
}
