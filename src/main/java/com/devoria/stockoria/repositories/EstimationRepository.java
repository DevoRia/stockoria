package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Estimation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstimationRepository extends MongoRepository<Estimation, ObjectId> {
}
