package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, ObjectId> {
}
