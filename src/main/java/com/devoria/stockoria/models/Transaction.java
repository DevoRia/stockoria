package com.devoria.stockoria.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Document(collection = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Transaction {

    @Id
    private ObjectId id;

    @Version
    private Long version;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date lastModifiedDate = new Date();

    @DocumentReference
    private Currency currency;

    private Double value;

    @DocumentReference
    private Transaction mutual;

    @DocumentReference
    private Fund fund;

    @DocumentReference
    private Category category;

    @DocumentReference
    private Item item;

    private Double itemAmount;

    @DocumentReference
    private User user;
}
