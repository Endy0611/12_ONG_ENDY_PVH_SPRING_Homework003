package com.example._2_ong_endy_pvh_spring_homework003.service.impl;

import com.example._2_ong_endy_pvh_spring_homework003.exception.BadRequestException;
import com.example._2_ong_endy_pvh_spring_homework003.exception.DuplicateUserException;
import com.example._2_ong_endy_pvh_spring_homework003.exception.NotFoundException;
import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Event;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.EventRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.VenueRequest;
import com.example._2_ong_endy_pvh_spring_homework003.repository.AttendeeRepository;
import com.example._2_ong_endy_pvh_spring_homework003.repository.EventAttendeeRepository;
import com.example._2_ong_endy_pvh_spring_homework003.repository.EventRepository;
import com.example._2_ong_endy_pvh_spring_homework003.repository.VenueRepository;
import com.example._2_ong_endy_pvh_spring_homework003.service.AttendeeService;
import com.example._2_ong_endy_pvh_spring_homework003.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventAttendeeRepository eventAttendeeRepository;
    private final VenueRepository venueRepository;
    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Event> getAllEvents(int page, int size) {
        int offset = size * (page-1);
        return eventRepository.getAllEvents(offset, size);
    }

    @Override
    public Event getEventById(Long eventId) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Event with ID " + eventId + " not found");
        }
        return eventRepository.getEventById(eventId);
    }

    @Override
    public Event deleteEventById(Long eventId) {
        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Event with ID " + eventId + " not found");
        }
        eventAttendeeRepository.deleteEventAttendeeByEventId(eventId);

        return eventRepository.deleteEventById(eventId);
    }


    @Override
    public Event saveEvent(EventRequest eventRequest) {
        if (eventRepository.existsByAttendeeName(eventRequest.getEventName())) {
            throw new DuplicateUserException("Attendee name already exists");
        }

        if (eventRequest.getEventDate().isBefore(LocalDate.now())){
            throw new BadRequestException("Event date must be in the future");
        }

        if (venueRepository.getVenueById(eventRequest.getVenueId()) == null) {
            throw new NotFoundException("Venue with ID " + eventRequest.getVenueId() + " not found");
        }

        for (Long attendeeId : eventRequest.getAttendeeId()) {
            if(attendeeRepository.getAttendeeById(attendeeId) == null) {
                throw new NotFoundException("Attendee with ID " + attendeeId + " not found");
            }
        }

        Event event = eventRepository.saveEvent(eventRequest);
        for( Long AttendeeId : eventRequest.getAttendeeId()) {
            eventAttendeeRepository.insertEventAttendee(AttendeeId, event.getEventId());
        }
        return eventRepository.getEventById(event.getEventId());
    }

    @Override
    public Event updateEventById(Long eventId, EventRequest eventRequest) {

        if (eventRepository.existsByAttendeeName(eventRequest.getEventName())) {
            throw new DuplicateUserException("Attendee name already exists");
        }

        if (eventRequest.getEventDate().isBefore(LocalDate.now())){
            throw new BadRequestException("Event date must be in the future");
        }

        if (eventRepository.getEventById(eventId) == null) {
            throw new NotFoundException("Event with id " + eventId + " not found");
        }

        if (venueRepository.getVenueById(eventRequest.getVenueId()) == null) {
            throw new NotFoundException("Venue with id " + eventRequest.getVenueId() + " not found");
        }

        for (Long attendeeId : eventRequest.getAttendeeId()) {
            if (attendeeRepository.getAttendeeById(attendeeId) == null) {
                throw new NotFoundException("Attendee with ID " + attendeeId + " not found");
            }
        }

        eventRepository.updateEventById(eventId, eventRequest);
        eventAttendeeRepository.deleteEventAttendeeByEventId(eventId);

        for (Long AttendeeId : eventRequest.getAttendeeId()) {
            eventAttendeeRepository.insertEventAttendee(AttendeeId, eventId);
        }

        return eventRepository.getEventById(eventId);
    }
}
