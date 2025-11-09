package com.example.gradeapp.repository;

import com.example.gradeapp.model.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentInfoRespository extends JpaRepository{
    Optional<StudentInfo> findByName(String name);
}
