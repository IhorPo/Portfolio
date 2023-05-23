package com.project_1.university.dataAccessLayer;

import com.project_1.university.models.TeacherPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherPojo,Integer> {
}
