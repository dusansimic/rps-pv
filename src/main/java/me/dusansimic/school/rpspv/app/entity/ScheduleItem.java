package me.dusansimic.school.rpspv.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;
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

    @NotNull
    private String subject;
    @NotNull
    @Enumerated(EnumType.STRING)
    private DayOfWeek day;
    @NotNull
    private LocalTime time;
    @NotNull
    private String comment;
    @NotNull
    private boolean mandatory;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ItemType type;

    @ManyToMany(mappedBy = "scheduleItems")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Student> students;
}
