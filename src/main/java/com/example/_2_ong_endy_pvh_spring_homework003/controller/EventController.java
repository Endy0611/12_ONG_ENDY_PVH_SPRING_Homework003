package com.example._2_ong_endy_pvh_spring_homework003.controller;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Event;
import com.example._2_ong_endy_pvh_spring_homework003.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework003.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvents(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
        ApiResponse<List<Event>> apiResponse = ApiResponse.<List<Event>>builder()
                .timestamp(Instant.now())
                .message("Retrieved events successfully")
                .status(HttpStatus.OK)
                .payload(eventService.getAllEvents(page, size))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@PathVariable("event_id") Long eventId) {
        ApiResponse<Event> apiResponse = ApiResponse.<Event>builder()
                .timestamp(Instant.now())
                .message(String.format("Retrieved event with id %d successfully", eventId))
                .status(HttpStatus.OK)
                .payload(eventService.getEventById(eventId))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{event_id}")
    public ResponseEntity<ApiResponse<Event>> deleteEventById(@PathVariable("event_id") Long eventId) {
        ApiResponse<Event> apiResponse = ApiResponse.<Event>builder()
                .timestamp(Instant.now())
                .message(String.format("Delete event with id %d successfully", eventId))
                .status(HttpStatus.OK)
                .payload(eventService.deleteEventById(eventId))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
