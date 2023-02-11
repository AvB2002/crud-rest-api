package com.itec116.activity.repository;

import com.itec116.activity.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity,Long> {

}
