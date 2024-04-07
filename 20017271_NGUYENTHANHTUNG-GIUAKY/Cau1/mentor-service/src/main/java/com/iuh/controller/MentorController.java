package com.iuh.controller;

import com.iuh.Model.Mentor;
import com.iuh.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
     private MentorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mentor create(@RequestBody Mentor mentor){
        return service.add(mentor);
    }

    @GetMapping
    public List<Mentor> getAll(){
        return service.findAll();
    }

    @GetMapping("/{mentorId}")
    public Mentor getMentor(@PathVariable String mentorId){
        return service.getMentorById(mentorId);
    }

}
