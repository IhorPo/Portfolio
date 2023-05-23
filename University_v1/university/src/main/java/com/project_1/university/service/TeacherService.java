package com.project_1.university.service;

import com.project_1.university.dataAccessLayer.TeacherRepository;
import com.project_1.university.models.TeacherPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<TeacherPojo> getAll(){
        return repository.findAll();
    }

    public TeacherPojo getById(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No such teacher")
        );
    }

    public TeacherPojo add(TeacherPojo teacher){
        return repository.save(teacher);
    }

    public TeacherPojo update(TeacherPojo teacher){
        Optional<TeacherPojo> teacher1 = repository.findById(teacher.getId());
        if(teacher1.isPresent()){
            TeacherPojo teacher2 = teacher1.get();
            teacher2.setName(teacher.getName());
            teacher2.setSurname(teacher.getSurname());
            teacher2.setEmail(teacher.getEmail());
            return repository.save(teacher2);
        } else {
            throw new NoSuchElementException("No such teacher");
        }
    }

    public void delete(Integer id){
        TeacherPojo teacher = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No such teacher")
        );
        repository.delete(teacher);
    }
}
