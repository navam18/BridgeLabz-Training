package com.example.student_management.service;

import com.example.student_management.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.student_management.entity.Student;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id,Student student){
        Student existingStudent=studentRepository.findById(id).orElse(null);
        if(existingStudent!=null){
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setAge(student.getAge());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }
}
