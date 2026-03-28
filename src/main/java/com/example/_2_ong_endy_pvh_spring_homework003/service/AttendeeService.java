package com.example._2_ong_endy_pvh_spring_homework003.service;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendees(int page, int size);

    Attendee getAttendeeById(Long attendeeId);

    Attendee deleteAttendeeById(Long attendeeId);
}
