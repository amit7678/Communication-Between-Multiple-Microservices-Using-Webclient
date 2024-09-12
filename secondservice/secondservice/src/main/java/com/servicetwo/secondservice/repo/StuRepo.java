package com.servicetwo.secondservice.repo;


import com.servicetwo.secondservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepo extends JpaRepository<Student,Integer> {
}
