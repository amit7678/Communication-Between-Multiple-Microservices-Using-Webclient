package com.serviceone.oneserv.service;

import com.serviceone.oneserv.entity.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ServiceA {
    private final WebClient webClient;

    /**
     * Constructor for ServiceA.
     * @param webClientBuilder The WebClient.Builder used to configure and create the WebClient instance.
     */
    public ServiceA(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090") // URL of Service B
                .build();
    }

    // Method to make a GET request to Service B
  /*  public Mono<String> getDataFromServiceB() {
        return webClient.get()
                .uri("/api/service-b/get-data")   // Service B's GET endpoint
                .retrieve()
                .bodyToMono(String.class);        // Convert the response to Mono<String>
    }*/


    /**
     * POST request to save a Student object to ServiceB.
     * This method sends a Student object to ServiceB's endpoint for saving.
     *
     * @param student The Student object to be saved.
     * @return A Mono wrapping the response from ServiceB.
     */
    public Mono<String> postStudentToServiceB(Student student) {
        return webClient.post()
                .uri("/api/service-b/save-student")     // Service B's POST endpoint
                .bodyValue(student)                     // Send employee object in request body
                .retrieve()
                .bodyToMono(String.class);               // Convert response to Mono<String>
    }
    /**
     * GET request to fetch all Student objects from ServiceB.
     * This method retrieves a list of all students from ServiceB's endpoint.
     *
     * @return A Mono wrapping a List of Student objects retrieved from ServiceB.
     */
    public Mono<List<Student>> getAllStudentsFromServiceB() {
        return webClient.get()
                .uri("/api/service-b/students")         // Service B's GET endpoint
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Student>>() {});  // Convert response to List<Employee>
    }

}
