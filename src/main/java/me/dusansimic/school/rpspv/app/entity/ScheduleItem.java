package me.dusansimic.school.rpspv.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class ScheduleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private int day;
    private int time;
    private String comment;
    private boolean mandatory;
    private String type;

    @ManyToMany(mappedBy = "scheduleItems")
    private Set<Student> students = new HashSet<>();
}
