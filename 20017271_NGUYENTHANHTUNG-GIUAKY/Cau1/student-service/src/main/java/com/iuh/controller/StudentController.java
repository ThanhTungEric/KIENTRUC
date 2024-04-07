package com.iuh.controller;

import com.iuh.Service.StudentService;
import com.iuh.config.RestemplateConfig;
import com.iuh.model.Student;
import com.iuh.model.StudentMentorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private RestemplateConfig restemplateConfig;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllOrders(){
        return service.findAllStudent();
    }

    @GetMapping("/v2/{studentId}")
    public Object getStudentMentor(@PathVariable String studentId) {
        Student order = service.getStudentById(studentId);
        String mentorId = order.getMentorId();
        // Gọi API khác dựa vào customerId
        String url = "http://localhost:8088/mentor/" + mentorId;
        return restemplateConfig.getForObject(url, Object.class);
    }

    @GetMapping("/v2/v1/{studentId}")
    public ResponseEntity<StudentMentorInfo> getStudentandMentor(@PathVariable String studentId) {
        Student student = service.getStudentById(studentId);
        String mentorId = student.getMentorId();
        // Gọi API khác dựa vào mentorId
        String url = "http://localhost:8088/mentor/" + mentorId;
        Object mentorInfo = restemplateConfig.getForObject(url, Object.class);

        // Tạo đối tượng StudentMentorInfo
        StudentMentorInfo studentMentorInfo = new StudentMentorInfo(student, mentorInfo);

        // Trả về dữ liệu dưới dạng JSON
        return new ResponseEntity<>(studentMentorInfo, HttpStatus.OK);
    }
}
