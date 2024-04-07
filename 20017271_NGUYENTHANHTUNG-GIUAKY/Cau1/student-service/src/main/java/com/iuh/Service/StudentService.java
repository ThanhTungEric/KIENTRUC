package com.iuh.Service;

import com.iuh.model.Student;
import com.iuh.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student){
        student.setStudentId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(student);
    }

    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    public Student getStudentById(String studentId){
        return repository.findById(studentId).get();
    }
}
