package me.dusansimic.school.rpspv.app.service;

import me.dusansimic.school.rpspv.app.entity.ScheduleItem;
import me.dusansimic.school.rpspv.app.repository.ScheduleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleItemService {
    private final ScheduleItemRepository repository;

    public ScheduleItemService(ScheduleItemRepository repository) {
        this.repository = repository;
    }

    public ScheduleItem addScheduleItem(ScheduleItem scheduleItem) {
        return repository.save(scheduleItem);
    }

    public void removeScheduleItem(Long id) {
        repository.deleteById(id);
    }

    public List<ScheduleItem> getAllScheduleItems() {
        return repository.findAll();
    }
}
