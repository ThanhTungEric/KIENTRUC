package com.iuh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String studentId;
    private String name;
    private String Age;
    private String mentorId;
}
