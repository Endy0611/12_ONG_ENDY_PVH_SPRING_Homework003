package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
