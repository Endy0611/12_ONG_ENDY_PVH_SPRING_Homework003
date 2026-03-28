package com.example._2_ong_endy_pvh_spring_homework003.controller;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import com.example._2_ong_endy_pvh_spring_homework003.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework003.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendees(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {

        ApiResponse<List<Attendee>> apiResponse = ApiResponse.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Retrieved attendees successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAllAttendees(page, size))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{attendee_id}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable("attendee_id") Long attendeeId) {
        ApiResponse<Attendee> apiResponse = ApiResponse.<Attendee>builder()
                .timestamp(Instant.now())
                .message(String.format("Retrieved attendee with id #d successfully", attendeeId))
                .status(HttpStatus.OK)
                .payload(attendeeService.getAttendeeById(attendeeId))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{attendee_id}")
    public ResponseEntity<ApiResponse<Attendee>> deleteAttendeeById(@PathVariable("attendee_id") Long attendeeId) {
        ApiResponse<Attendee> apiResponse = ApiResponse.<Attendee>builder()
                .timestamp(Instant.now())
                .message(String.format("Retrieved attendee with id %d successfully", attendeeId))
                .status(HttpStatus.OK)
                .payload(attendeeService.deleteAttendeeById(attendeeId))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
