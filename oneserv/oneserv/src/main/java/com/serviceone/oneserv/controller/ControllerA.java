package com.serviceone.oneserv.controller;

import com.serviceone.oneserv.entity.Student;
import com.serviceone.oneserv.service.ServiceA;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/service-a")
public class ControllerA {

    private final ServiceA serviceAService;


    /**
     * Constructor for ControllerA.
     * @param serviceAService The ServiceA instance to be used for communication with ServiceB.
     */
    public ControllerA(ServiceA serviceAService) {
        this.serviceAService = serviceAService;
    }

 /*   @GetMapping("/call-service-b")
    public Mono<String> callServiceB() {
        return serviceAService.getDataFromServiceB();
    }*/

    /**
     * POST endpoint to send a Student object to ServiceB.
     * This endpoint receives a Student object in the request body and forwards it to ServiceB for processing.
     *
     * @param student The Student object to be sent to ServiceB.
     * @return A Mono wrapping the response from ServiceB.
     */
    @PostMapping("/post-to-service-b")
    public Mono<String> postToServiceB(@RequestBody Student student) {
        return serviceAService.postStudentToServiceB(student);
    }
    /**
     * GET endpoint to fetch all Student objects from ServiceB.
     * This endpoint retrieves a list of all students from ServiceB.
     *
     * @return A Mono wrapping a List of Student objects retrieved from ServiceB.
     */
    // GET endpoint to fetch all employees from Service B
    @GetMapping("/get-all-students")
    public Mono<List<Student>> getAllStudents() {
        return serviceAService.getAllStudentsFromServiceB();
    }

}
