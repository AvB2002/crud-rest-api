package com.itec116.activity.controller;


import com.itec116.activity.model.Student;
import com.itec116.activity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody Student student){
        if(studentService.saveStudent(student) == 1){
            return new ResponseEntity("Success Insert", HttpStatus.CREATED);
        }else {
            return new ResponseEntity("Failed Insert", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getStudents")
    public ResponseEntity getStudentDetails(){
        return new ResponseEntity(studentService.getAllStudent(), HttpStatus.OK);
    }


    @GetMapping("/getStudent/{id}")
    public ResponseEntity getStudentDetails(@PathVariable(value = "id") Long id){
        if(studentService.getStudent(id)!=null){
            return new ResponseEntity(studentService.getStudent(id), HttpStatus.OK);
        }else {
            return new ResponseEntity("No student record", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable(value = "id") Long id){
        if(studentService.getStudent(id)!=null){
            return new ResponseEntity(studentService.deleteStudentById(id), HttpStatus.OK);
        }else {
            return new ResponseEntity("No student record",HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student){
        if(studentService.saveStudent(student) == 1){
            return new ResponseEntity("Success Update", HttpStatus.OK);
        }else {
            return new ResponseEntity("Failed Update", HttpStatus.BAD_REQUEST);
        }
    }


}
