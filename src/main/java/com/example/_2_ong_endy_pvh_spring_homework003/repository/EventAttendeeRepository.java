package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventAttendeeRepository {

    @Results(id = "eventAttendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })

    @Select("""
    SELECT a.* FROM event_attendee ea
    INNER JOIN attendees a
    ON ea.attendee_id = a.attendee_id
    WHERE ea.event_id = #{eventId}
    """)
    List<Attendee> getAttendeeByEventId(Long eventId);
}
