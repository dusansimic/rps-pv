package me.dusansimic.school.rpspv.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Convert(converter = StudentIndexConverter.class)
    @Column(nullable = false, unique = true)
    private StudentIndex index;
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    @ManyToMany
    @JoinTable(
            name = "student_scheduleitem",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_item_id")
    )
    private Set<ScheduleItem> scheduleItems = new HashSet<>();
}
