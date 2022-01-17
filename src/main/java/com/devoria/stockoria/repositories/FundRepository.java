package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Fund;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FundRepository extends MongoRepository<Fund, ObjectId> {


    @Query("{ 'user' : ObjectId('?0') }")
    List<Fund> findAllByUser(String userId);

}
