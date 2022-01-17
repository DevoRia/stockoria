package com.devoria.stockoria.repositories;

import com.devoria.stockoria.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    default void initUser(String username) {
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

    @Query("{ 'username' : ?0 }")
    User findUserByUsername(String username);

}
