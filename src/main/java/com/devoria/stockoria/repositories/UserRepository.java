package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.User;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    default void findOneAndModifyByUsername(String username) {
        User userExample = new User();
        userExample.setUsername(username);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIncludeNullValues().withIgnorePaths("id", "createdDate", "lastModifiedDate");

        Example<User> ex = Example.of(userExample, matcher);
        Optional<User> userMaybe = this.findOne(ex);

        if (userMaybe.isEmpty()) {
            this.save(userExample);
        }
    }

}
