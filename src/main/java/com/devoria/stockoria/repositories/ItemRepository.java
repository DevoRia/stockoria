package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Fund;
import com.devoria.stockoria.models.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, ObjectId> {

    @Query("{ 'user' : ObjectId('?0') }")
    List<Item> findAllByUser(String userId);

}
