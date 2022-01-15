package com.devoria.stockoria.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.util.Date;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@EnableMongoAuditing
public class User {

    @Id
    private ObjectId id;
    @Version
    private Long version;
    @CreatedDate
    private Date createdDate = new Date();
    @LastModifiedDate
    private Date lastModifiedDate = new Date();
    private String username;
    private String email;

}