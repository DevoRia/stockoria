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
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Document(collection = "items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Item {

    @Id
    private ObjectId id;

    @Version
    private Long version;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date lastModifiedDate = new Date();

    private String name;

    @DocumentReference
    private Currency currency;

    @DocumentReference
    private List<Price> prices;

    @DocumentReference
    private Fund fund;

    @DocumentReference
    private Category category;

    @DocumentReference
    private User user;
}
