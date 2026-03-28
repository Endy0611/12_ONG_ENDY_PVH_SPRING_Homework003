package com.example._2_ong_endy_pvh_spring_homework003.model.entity;

import com.example._2_ong_endy_pvh_spring_homework003.model.request.AttendeeRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long eventId;
    private String eventName;
    private String eventDate;
    private Venue venue;
    private List<Attendee> attendee;
}
