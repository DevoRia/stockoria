package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, ObjectId> {
}
