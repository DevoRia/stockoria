package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Fund;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundRepository extends MongoRepository<Fund, ObjectId> {
}
