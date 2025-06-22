package me.dusansimic.school.rpspv.app.repository;

import me.dusansimic.school.rpspv.app.entity.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, Long> {
}
