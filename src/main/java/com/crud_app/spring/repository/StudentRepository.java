package com.crud_app.spring.repository;

import com.crud_app.spring.structure.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    //all crud db methods
}
