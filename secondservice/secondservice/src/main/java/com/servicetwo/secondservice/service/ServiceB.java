package com.servicetwo.secondservice.service;

import com.servicetwo.secondservice.entity.Student;
import com.servicetwo.secondservice.repo.StuRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ServiceB {

    private final StuRepo stuRepo;

    /**
     * Constructor for ServiceB.
     * @param stuRepo The StuRepo instance used to access and manipulate Student data in the repository.
     */
    public ServiceB(StuRepo stuRepo) {
        this.stuRepo = stuRepo;
    }

    /**
     * Save a Student object to the repository.
     * This method saves the provided Student object using the repository and returns a success message wrapped in a Mono.
     *
     * @param student The Student object to be saved.
     * @return A Mono wrapping a confirmation message indicating that the Student was saved successfully.
     */
    public Mono<String> saveStudent(Student student) {
        stuRepo.save(student);
        return Mono.just("Employee saved successfully!");
    }
    /**
     * Retrieve all Student objects from the repository.
     * This method fetches all students from the repository and returns them wrapped in a Mono.
     *
     * @return A Mono wrapping a List of all Student objects retrieved from the repository.
     */
    public Mono<List<Student>> getAllStudents() {
        List<Student> students = stuRepo.findAll();
        return Mono.just(students);
    }

}
