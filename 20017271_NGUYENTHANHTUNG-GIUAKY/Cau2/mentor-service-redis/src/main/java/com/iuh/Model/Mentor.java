package com.iuh.Model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
public class Mentor implements Serializable {
    private String mentorId;
    private String name;
    private String Address;
}
