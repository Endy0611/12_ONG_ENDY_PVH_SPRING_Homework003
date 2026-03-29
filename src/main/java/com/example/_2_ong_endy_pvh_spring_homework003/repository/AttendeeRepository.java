package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Attendee;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.AttendeeRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.AttendeeUpdateRequest;
import jakarta.validation.constraints.*;
import lombok.NonNull;
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


    @ResultMap("attendeeMapper")
    @Select("""
        UPDATE attendees SET attendee_name = #{req.attendeeName} WHERE attendee_id = #{attendeeId} RETURNING *
    """)
    Attendee updateAttendeeById(Long attendeeId,@Param("req") AttendeeUpdateRequest attendeeUpdateRequest);


    @Select("""
        SELECT EXISTS(SELECT 1 FROM attendees WHERE attendee_name = #{attendeeName})
    """)
    boolean existsByAttendeeName(@NotBlank(message = "Attendee name cannot be blank") @NonNull @Size(min = 1, max = 50, message = "Attendee name must be between 1 and 50 characters") String attendeeName);



    @Select("""
        SELECT EXISTS(SELECT 1 FROM attendees WHERE email = #{email})
    """)
    boolean existsByAttendeeEmail(@NotNull @NotBlank(message = "Email must be a valid format (e.g., abc@gmail.com)") @Email(message = "Invalid email format") @Pattern(
            regexp = "^[a-zA-Z0-9]+@gmail\\.com$",
            message = "Email must be a valid format (e.g., abc@gmail.com)"
    ) String email);
}
