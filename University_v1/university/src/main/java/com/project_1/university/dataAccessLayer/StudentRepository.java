package com.project_1.university.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project_1.university.models.StudentPojo;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentPojo,Integer> {
}
