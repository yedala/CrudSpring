package com.example.basiccrud.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public void addNewStudents(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Integer Id){
        studentRepository.deleteById(Id);
    }

    @Transactional

    public void updateStudent(Integer Id,String name){
        Student student = studentRepository.findById(Id).orElseThrow(
                ()-> new IllegalStateException("not there")
        );
        student.setName(name);
        System.out.println(student);
    }
}
