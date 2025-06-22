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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String index;
    private String email;
    private String name;
    private String surname;

    @ManyToMany
    @JoinTable(
            name = "student_scheduleitem",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_item_id")
    )
    private Set<ScheduleItem> scheduleItems = new HashSet<>();
}
