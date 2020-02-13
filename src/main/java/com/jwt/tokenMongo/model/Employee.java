package com.jwt.tokenMongo.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "empl")
public class Employee {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String empId;
    @Indexed(unique = true)
    private String name;
    private String designation;
    private Double salary;
}