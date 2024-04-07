package com.iuh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Data
@AllArgsConstructor@NoArgsConstructor
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String phoneNumber;
}
