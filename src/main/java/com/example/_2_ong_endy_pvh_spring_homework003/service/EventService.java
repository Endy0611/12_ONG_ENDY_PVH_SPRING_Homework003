package com.example._2_ong_endy_pvh_spring_homework003.service;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Event;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(int page, int size);

    Event getEventById(Long eventId);

    Event deleteEventById(Long eventId);

    Event saveEvent(EventRequest eventRequest);

    Event updateEventById(Long eventId, EventRequest eventRequest);
}
