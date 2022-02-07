package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Category;
import com.devoria.stockoria.models.Fund;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, ObjectId> {

    @Query("{ 'user' : ObjectId('?0') }")
    List<Category> findAllByUser(String userId);

}
