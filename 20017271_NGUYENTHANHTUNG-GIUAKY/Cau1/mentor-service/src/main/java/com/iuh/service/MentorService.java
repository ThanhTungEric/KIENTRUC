package com.iuh.service;
import com.iuh.Model.Mentor;
import com.iuh.repository.MentorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MentorService {
    @Autowired
    private MentorRepo repo;
    public Mentor add(Mentor mentor){
        mentor.setMentorId(UUID.randomUUID().toString().split("-")[0]);
        return repo.save(mentor);
    }

    public List<Mentor> findAll(){
        return repo.findAll();
    }

    public Mentor getMentorById(String mentorId){
        return repo.findById(mentorId).get();
    }
}
