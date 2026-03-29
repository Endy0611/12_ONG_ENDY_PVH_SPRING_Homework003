package com.example._2_ong_endy_pvh_spring_homework003.repository;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Venue;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.VenueRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.response.ApiResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Mapper
public interface VenueRepository {

    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
    })
    @Select("""
        SELECT * FROM venues OFFSET #{offset} LIMIT #{size}
    """)
    List<Venue> getAllVenues(int offset, int size);


    @ResultMap("venueMapper")
    @Select("""
        SELECT * FROM venues WHERE venue_id = #{venueId}
    """)
    Venue getVenueById(Long venueId);

    @ResultMap("venueMapper")
    @Select("""
        DELETE FROM venues WHERE venue_id = #{venueId} RETURNING NULL
    """)
    Venue deleteVenueById(Long venueId);


    @ResultMap("venueMapper")
    @Select("""
        INSERT INTO venues VALUES (default, #{req.venueName}, #{req.location}) RETURNING *
    """)
    Venue saveVenue(@Param("req") VenueRequest venueRequest);


    @ResultMap("venueMapper")
    @Select("""
        UPDATE venues SET venue_name = #{req.venueName}, location = #{req.location} WHERE venue_id = #{venueId} RETURNING *
    """)
    Venue updateVenueById(Long venueId,@Param("req") VenueRequest venueRequest);

    @Select("""
           SELECT EXISTS(SELECT 1 FROM venues WHERE venue_name = #{venueName})
    """)
    boolean existsByAttendeeName(@NotNull @NotBlank(message = "Venue name cannot be blank") @Size(min = 1, max = 100, message = "Venue name must not exceed 100 characters") String venueName);
}
