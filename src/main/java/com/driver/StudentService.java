package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }

    public void createStudentDirectorPair(String student, String teacher){
        studentRepository.saveStudentTeacherPair(student, teacher);
    }

    public Student findStudent(String studentName){
        return studentRepository.findStudent(studentName) ;
    }

    public Teacher findTeacher(String TeacherName){
        return studentRepository.findTeacher(TeacherName);
    }

    public List<String>  findStudentTeacherPair(String teacher){
        return studentRepository. findStudentTeacherPair(teacher);
    }

    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
