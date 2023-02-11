package com.itec116.activity.service;


import com.itec116.activity.entity.StudentEntity;
import com.itec116.activity.model.Student;
import com.itec116.activity.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    public int saveStudent(Student student){
        try{
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(student.getId());
            studentEntity.setFirstName(student.getFirstName());
            studentEntity.setMiddleName(student.getMiddleName());
            studentEntity.setLastName(student.getLastName());
            studentEntity.setBirthday(student.getBirthday());
            studentEntity.setAge(student.getAge());
            studentDao.save(studentEntity);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }

    //Fetch All students available in in Student
    public ArrayList<StudentEntity> getAllStudent(){
        return (ArrayList<StudentEntity>) studentDao.findAll(); //select * from <tablename>
    }

    public StudentEntity getStudent(Long studentId){
        if(studentDao.findById(studentId).isPresent()){
            return studentDao.findById(studentId).get();
        }else{
            return null;
        }
    }

    public String deleteStudentById(Long studentId){
        try{
            studentDao.deleteById(studentId);
            return "Student is deleted";
        }catch (Exception e){
            return "Student is not deleted";
        }
    }

    public int updateStudent(Student student){
        try{
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(student.getId());
            studentEntity.setFirstName(student.getFirstName());
            studentEntity.setMiddleName(student.getMiddleName());
            studentEntity.setLastName(student.getLastName());
            studentEntity.setBirthday(student.getBirthday());
            studentEntity.setAge(student.getAge());
            studentDao.save(studentEntity);
            return 1;
        }catch (Exception e){
            return -1;
        }
    }


}
