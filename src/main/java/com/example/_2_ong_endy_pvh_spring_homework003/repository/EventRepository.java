package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Event;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "attendee", column = "event_id", many = @Many (select = "com.example._2_ong_endy_pvh_spring_homework003.repository.EventAttendeeRepository.getAttendeeByEventId")),
            @Result(property = "venue", column = "venue_id", one = @One (select = "com.example._2_ong_endy_pvh_spring_homework003.repository.VenueRepository.getVenueById"))
    })
    @Select("""
        SELECT * FROM events OFFSET #{offset} LIMIT #{size} 
    """)
    List<Event> getAllEvents(int offset, int size);

    @ResultMap("eventMapper")
    @Select("""
        SELECT * FROM events WHERE event_id = #{eventId} 
    """)
    Event getEventById(Long eventId);

    @ResultMap("eventMapper")
    @Select("""
        DELETE FROM events WHERE event_id = #{eventId} RETURNING NULL
    """)
    Event deleteEventById(Long eventId);


    @ResultMap("eventMapper")
    @Select("""
        INSERT INTO events VALUES (default, #{req.eventName}, #{req.eventDate}, #{req.venueId}) RETURNING *
    """)
    Event saveEvent(@Param("req") EventRequest eventRequest);


    @ResultMap("eventMapper")
    @Select("""
        UPDATE events SET event_name = #{req.eventName}, event_date = #{req.eventDate}, venue_id = #{req.venueId} WHERE event_id = #{eventId}
    """)
    Event updateEventById(Long eventId,@Param("req") EventRequest eventRequest);
}
