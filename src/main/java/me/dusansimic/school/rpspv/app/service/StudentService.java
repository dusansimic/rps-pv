package me.dusansimic.school.rpspv.app.service;

import me.dusansimic.school.rpspv.app.entity.ScheduleItem;
import me.dusansimic.school.rpspv.app.entity.Student;
import me.dusansimic.school.rpspv.app.repository.ScheduleItemRepository;
import me.dusansimic.school.rpspv.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<ScheduleItem> getAllScheduleItems(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
        System.out.println(student);
        System.out.println(student.getScheduleItems());
        return student.getScheduleItems().stream().toList();
    }

    public ScheduleItem addScheduleItem(Long studentId, Long scheduleItemId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student with id " + studentId + " not found"));
        ScheduleItem scheduleItem = scheduleItemRepository.findById(scheduleItemId).orElseThrow(() -> new RuntimeException("ScheduleItem with id " + scheduleItemId + " not found"));
        student.getScheduleItems().add(scheduleItem);
        return scheduleItemRepository.save(scheduleItem);
    }
}
