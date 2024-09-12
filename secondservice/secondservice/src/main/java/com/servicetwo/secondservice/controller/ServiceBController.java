package com.servicetwo.secondservice.controller;

import com.servicetwo.secondservice.entity.Student;
import com.servicetwo.secondservice.repo.StuRepo;
import com.servicetwo.secondservice.service.ServiceB;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/service-b")
public class ServiceBController {

    private final ServiceB serviceB;

    /**
     * Constructor for ServiceBController.
     * @param serviceB The ServiceB instance used to perform business operations related to Student objects.
     */
    public ServiceBController(ServiceB serviceB) {
        this.serviceB = serviceB;

    }

    /**
     * POST endpoint to save a Student object.
     * This endpoint receives a Student object in the request body and delegates the saving operation to ServiceB.
     *
     * @param student The Student object to be saved.
     * @return A Mono wrapping a confirmation message or status from ServiceB.
     */
    @PostMapping("/save-student")
    public Mono<String> saveStudent(@RequestBody Student student) {
        return serviceB.saveStudent(student);
    }

  /*  // Sample GET endpoint for Service A
    @GetMapping("/get-data")
    public Mono<String> getData() {
        return Mono.just("Data from Service B");
    }*/
    /**
     * GET endpoint to fetch all Student objects.
     * This endpoint retrieves a list of all students and returns it.
     *
     * @return A Mono wrapping a List of Student objects.
     */
    @GetMapping("/students")
    public Mono<List<Student>> getAllStudent() {
       return  serviceB.getAllStudents();

    }
}
