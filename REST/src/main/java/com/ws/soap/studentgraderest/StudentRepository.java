package com.ws.soap.studentgraderest;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private static Map<Integer, Student> studentRepo = new HashMap<>();
    public StudentRepository() {
        studentRepo.put(1,new Student(1,"FirstStudent",10));
        studentRepo.put(2,new Student(2,"SecondStudent",11));
        studentRepo.put(3,new Student(3,"ThirdStudent",12));
    }

    public Map<Integer,Student> viewAllStudent() {
        return studentRepo;
    }
    public Map<Integer,Student> addNewStudent(Student student) {
        studentRepo.put(student.getId(), student);
        return studentRepo;
    }
    public Map<Integer,Student> updateStudent(String name,double grade) {
        Student newStudent = null;
        int key = 0;

        for (Map.Entry<Integer, Student> entry : studentRepo.entrySet()) {
            Student student = entry.getValue();
            if (student.getName().equals(name)) {
                newStudent = student;
            }
        }

        key= newStudent.getId();
        studentRepo.remove(key);
        newStudent.setGrade(grade);

        studentRepo.put(key,newStudent);
        return studentRepo;

    }
    public Map<Integer,Student> deleteStudent(String name) {
        Student newStudent = null;
        int key = 0;

        for (Map.Entry<Integer, Student> entry : studentRepo.entrySet()) {
            Student student = entry.getValue();
            if (student.getName().equals(name)) {
                newStudent = student;
            }
        }

        key= newStudent.getId();
        studentRepo.remove(key);
        return studentRepo;
    }
}
