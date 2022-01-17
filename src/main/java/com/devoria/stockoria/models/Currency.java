package com.devoria.stockoria.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "currencies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EnableMongoAuditing
public class Currency {

    @Id
    private ObjectId id;
    @Version
    private Long version;
    @CreatedDate
    private Date createdDate = new Date();
    @LastModifiedDate
    private Date lastModifiedDate = new Date();
    private String code;
    private String name;
    private String symbol;

}
