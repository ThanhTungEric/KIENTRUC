package com.iuh.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mentors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {
    @Id
    private String mentorId;
    private String name;
    private String Address;
}
