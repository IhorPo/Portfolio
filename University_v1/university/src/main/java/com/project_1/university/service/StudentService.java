package com.project_1.university.service;

import com.project_1.university.dataAccessLayer.StudentRepository;
import com.project_1.university.models.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;
    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentPojo> getAll(){
        return repository.findAll();
    }

    public StudentPojo findById(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No such student")
        );
    }

    public StudentPojo add(StudentPojo student){
        return repository.save(student);
    }

    public StudentPojo update(StudentPojo student){
        Optional<StudentPojo> student1 = repository.findById(student.getId());
        if(student1.isPresent()){
            StudentPojo student2 = student1.get();
            student2.setName(student.getName());
            student2.setSurname(student.getSurname());
            student2.setEmail(student.getEmail());
            student2.setStudentGroup(student.getStudentGroup());
            return repository.save(student2);
        }else {
            throw new NoSuchElementException("No such student");
        }
    }

    public void delete(Integer id){
        StudentPojo student = repository.findById(id).orElseThrow(
                () ->new NoSuchElementException("No such student")
        );
        repository.delete(student);
    }
}
