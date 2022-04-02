package com.crud_app.spring.controller;

import com.crud_app.spring.ExModel;
import com.crud_app.spring.exception.ResourceNotFoundException;
import com.crud_app.spring.repository.StudentRepository;
import com.crud_app.spring.structure.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //Fetching entries RestAPI
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //creating entries RestAPI
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //get student by roll RestAPI
    @GetMapping("{roll}")
    public ResponseEntity<?> getStudentByRoll(@PathVariable Integer roll){
        Student student = null;
        try {
            student = studentRepository.findById(roll).orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with roll.no- " + roll));
            return ResponseEntity.ok(student);
        } catch (Exception ex) {

        }
        return new ResponseEntity<>(new ExModel("Student was not found, Try another roll number."), HttpStatus.NOT_FOUND);
    }

    //update student RestAPI
    @PutMapping("{roll}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer roll,@RequestBody Student studentDetails) {
        Student updateStudent = null;
        try {
            updateStudent = studentRepository.findById(roll).orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with roll.no- " + roll));
            updateStudent.setFirst(studentDetails.getFirst());
            updateStudent.setLast(studentDetails.getLast());
            updateStudent.setClas(studentDetails.getClas());
            updateStudent.setGrade(studentDetails.getGrade());
            updateStudent.setDivi(studentDetails.getDivi());

            studentRepository.save(updateStudent);

            return ResponseEntity.ok(updateStudent);
        } catch (Exception ex){
        }
        return new ResponseEntity(new ExModel("Cannot create data entry"), HttpStatus.NOT_FOUND);
    }

    //deleting Student RestAPI
    @DeleteMapping("{roll}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Integer roll){
        Student student = null;
        try {
            student = studentRepository.findById(roll).orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with roll.no- " + roll));
            studentRepository.delete(student);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
        }
        return new ResponseEntity(new ExModel("Roll number was not found."), HttpStatus.NOT_FOUND);
    }
}
