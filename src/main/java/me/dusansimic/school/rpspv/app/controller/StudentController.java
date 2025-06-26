package me.dusansimic.school.rpspv.app.controller;

import me.dusansimic.school.rpspv.app.entity.ScheduleItem;
import me.dusansimic.school.rpspv.app.entity.Student;
import me.dusansimic.school.rpspv.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student saved = studentService.addStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}/scheduleItem")
    public ResponseEntity<List<ScheduleItem>> getScheduleItem(@PathVariable Long id) {
        List<ScheduleItem> scheduleItems = studentService.getAllScheduleItems(id);
        return ResponseEntity.ok(scheduleItems);
    }

    @PostMapping("/{studentId}/scheduleItem/{scheduleItemId}")
    public ResponseEntity<ScheduleItem> addScheduleItem(@PathVariable Long studentId, @PathVariable Long scheduleItemId) {
        ScheduleItem saved = studentService.addScheduleItem(studentId, scheduleItemId);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
