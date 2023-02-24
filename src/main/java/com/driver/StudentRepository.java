package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {


     private HashMap<String,Student>studentMap;
    private HashMap<String, Teacher>teacherMap;
    private HashMap<String, List<String>>StudentTeacherMap;


    public StudentRepository() {
        this.studentMap = new HashMap<String ,Student>();
        this.teacherMap = new HashMap<String ,Teacher>();
        this.StudentTeacherMap = new HashMap<String, List<String>>();
    }
    public void saveStudent(Student student){
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }
    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            studentMap.put(student, studentMap.get(student));
            teacherMap.put(teacher, teacherMap.get(teacher));
            List<String> StudentTeacherList = new ArrayList<String>();
            if(StudentTeacherMap.containsKey(teacher))
                StudentTeacherList  = StudentTeacherMap.get(teacher);
            StudentTeacherList.add(student);
            StudentTeacherMap.put(teacher,StudentTeacherList);
        }
    }

    public Student findStudent(String student){
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String> findStudentTeacherPair(String teacher){
        List<String> studentteacherList = new ArrayList<String>();
        if(StudentTeacherMap.containsKey(teacher))
            studentteacherList = StudentTeacherMap.get(teacher);
        return studentteacherList;
    }

    public List<String> findAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        List<String> students = new ArrayList<String>();
        if(StudentTeacherMap.containsKey(teacher)){
            students = StudentTeacherMap.get(teacher);
            for(String student: students){
                if(studentMap.containsKey(student))
                {
                    studentMap.remove(student);
                }
            }

            StudentTeacherMap.remove(teacher);
        }

        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        HashSet<String> studentsSet = new HashSet<String>();

        for(String teacher: StudentTeacherMap.keySet()){
            for(String student: StudentTeacherMap.get(teacher)){
                studentsSet.add(student);
            }
        }

        for(String student: studentsSet){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
    }
}
