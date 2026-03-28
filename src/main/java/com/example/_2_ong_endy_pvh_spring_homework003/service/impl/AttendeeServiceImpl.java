package com.example._2_ong_endy_pvh_spring_homework003.service.impl;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import com.example._2_ong_endy_pvh_spring_homework003.repository.AttendeeRepository;
import com.example._2_ong_endy_pvh_spring_homework003.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Attendee> getAllAttendees(int page, int size) {
        int offset = size * (page-1);
        return attendeeRepository.getAllAttendees(offset, size);
    }
}
