package me.dusansimic.school.rpspv.app.controller;

import me.dusansimic.school.rpspv.app.entity.ScheduleItem;
import me.dusansimic.school.rpspv.app.service.ScheduleItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduleItem")
public class ScheduleItemController {
    private final ScheduleItemService  scheduleItemService;

    public ScheduleItemController(ScheduleItemService scheduleItemService) {
        this.scheduleItemService = scheduleItemService;
    }

    @PostMapping
    public ResponseEntity<ScheduleItem> addScheduleItem(@RequestBody ScheduleItem scheduleItem) {
        ScheduleItem saved = scheduleItemService.addScheduleItem(scheduleItem);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleItem> deleteScheduleItem(@PathVariable Long id) {
        scheduleItemService.removeScheduleItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ScheduleItem>> getAllScheduleItems() {
        return ResponseEntity.ok(scheduleItemService.getAllScheduleItems());
    }
}
