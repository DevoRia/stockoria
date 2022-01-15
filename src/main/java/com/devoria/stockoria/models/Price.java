package com.devoria.stockoria.models;

import com.devoria.stockoria.enums.PriceCategory;
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

@Document(collection = "prices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Price {
    @Id
    private ObjectId id;

    @Version
    private Long version;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date lastModifiedDate = new Date();

    private Double value;

    @DocumentReference
    private Currency currency;

    private PriceCategory priceCategory;
}
