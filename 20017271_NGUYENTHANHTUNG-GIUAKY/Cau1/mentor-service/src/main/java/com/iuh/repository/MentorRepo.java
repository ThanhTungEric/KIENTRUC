package com.iuh.repository;

import com.iuh.Model.Mentor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MentorRepo extends MongoRepository<Mentor, String> {
}
