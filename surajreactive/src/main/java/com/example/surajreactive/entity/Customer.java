package com.example.surajreactive.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.io.Serializable;
import java.util.Date;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Customer")
public class Customer  {


    @Id
    private String id;

    @Field(value = BaseMongo.FIRST_NAME)
    private String firstName;


    @Indexed
    @Field(value =BaseMongo.MIDDLE_NAME)
    private String middleName;

    @Field(value = BaseMongo.LAST_NAME)
    private String lastName;

    @Indexed(unique = true)
    @Field(BaseMongo.MOBILE_NUMBER)
    private long mobileNo;

    @Version
    @Field(BaseMongo.VERSION)
    private Long version;

    @Field(value= BaseMongo.CREATED_DATE)
    @CreatedDate
    private Date CreatedDate;

    @Field(value = BaseMongo.CREATED_BY)
    @CreatedBy
    private String CreatedBy;

    @Field(value = BaseMongo.UPDATED_DATE)
    @LastModifiedDate
    private Date updatedDate;

    @Field(value = BaseMongo.UPDATED_BY)
    @LastModifiedBy
    private String updatedBy;

    @Field(value = BaseMongo.IS_DELETED)
    private boolean isDeleted;




}
