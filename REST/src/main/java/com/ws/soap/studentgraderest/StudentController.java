package com.ws.soap.studentgraderest;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="/ws/grade")
public class StudentController {
    private static StudentRepository Students;
    @GetMapping(path="/index")
    public String studentRepositoryInitializer()
    {
        Students= new StudentRepository();
        return String.format("Hey there! Congratulations on creating your first Spring Boot Rest Service to initialize your students' repository...");
    }

    // GET endpoint to get all student
    @RequestMapping("/allStudent")
    @GetMapping
    public Map getAllStudents()
    {
        return Students.viewAllStudent();
    }
    // POST endpoint to add a new student
    @RequestMapping("/addStudent")
    @PostMapping
    public Map addStudent (@RequestParam int id, @RequestParam String name, @RequestParam double grade)
    {
        Student newStd=new Student (id, name, grade);
        return Students.addNewStudent (newStd);
    }
    // PUT endpoint to update a student's grade
    @RequestMapping(value="/updateStudent")
    @PutMapping
    public Map updateStudentGrade (@RequestParam String name, @RequestParam double grade)
    {
        return Students.updateStudent (name, grade);
    }
    // DELETE endpoint to delete a student
    @RequestMapping(value="/deleteStudent")
    @DeleteMapping
    public Map deleteStudentGrade (@RequestParam String name)
    {
        return Students.deleteStudent(name);
    }

}
