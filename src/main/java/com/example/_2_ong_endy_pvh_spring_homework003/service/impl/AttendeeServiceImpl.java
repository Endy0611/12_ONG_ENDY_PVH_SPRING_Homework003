package com.example._2_ong_endy_pvh_spring_homework003.service.impl;

import com.example._2_ong_endy_pvh_spring_homework003.exception.DuplicateUserException;
import com.example._2_ong_endy_pvh_spring_homework003.exception.NotFoundException;
import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.AttendeeRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.AttendeeUpdateRequest;
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

    @Override
    public Attendee getAttendeeById(Long attendeeId) {
        Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);

        if (attendee == null ) {
            throw new NotFoundException("Attendee with id " + attendeeId + " not found");
        }
        return attendee;
    }

    @Override
    public Attendee deleteAttendeeById(Long attendeeId) {
        Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);
        if (attendee == null ) {
            throw new NotFoundException("Attendee with id " + attendeeId + " not found");
        }
        return attendeeRepository.deleteAttendeeById(attendeeId);
    }

    @Override
    public Attendee saveAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.saveAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendeeById(Long attendeeId, AttendeeUpdateRequest attendeeUpdateRequest) {
        return attendeeRepository.updateAttendeeById(attendeeId, attendeeUpdateRequest);
    }
}
