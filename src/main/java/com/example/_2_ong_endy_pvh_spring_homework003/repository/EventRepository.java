package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venueId", column = "venue_id", one = @One(select = "com.example._2_ong_endy_pvh_spring_homework003.repository.VenueRepository.getVenueById")),
    })
    @Select("""
        SELECT * FROM events OFFSET #{offset} LIMIT #{size} 
    """)
    List<Event> getAllEvents(int offset, int size);
}
