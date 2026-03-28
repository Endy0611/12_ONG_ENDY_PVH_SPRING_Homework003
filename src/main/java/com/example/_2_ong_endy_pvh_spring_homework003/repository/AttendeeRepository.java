package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })

    @Select("""
        SELECT * FROM attendees OFFSET #{offset} LIMIT #{size}
    """)


    List<Attendee> getAllAttendees(int offset, int size);


    @ResultMap("attendeeMapper")
    @Select("""
        SELECT * FROM attendees WHERE attendee_id = #{attendeeId}
    """)
    Attendee getAttendeeById(Long attendeeId);

    @ResultMap("attendeeMapper")
    @Select("""
        DELETE FROM attendees WHERE attendee_id = #{attendeeId} RETURNING NULL
    """)
    Attendee deleteAttendeeById(Long attendeeId);


    @ResultMap("attendeeMapper")
    @Select("""
        INSERT INTO attendees VALUES (default, #{req.attendeeName}, #{req.email}) RETURNING  *
    """)
    Attendee saveAttendee(@Param("req") AttendeeRequest attendeeRequest);
}
