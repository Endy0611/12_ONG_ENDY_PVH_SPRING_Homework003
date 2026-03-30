package com.example._2_ong_endy_pvh_spring_homework003.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    @NotBlank(message = "Event name cannot be blank")
    private String eventName;

    @NotNull(message = "Event date is required")
//    @NotBlank
    private LocalDate eventDate;

    @NotNull
    @NotNull(message = "Venue ID is required")
    @Positive(message = "Venue ID must be positive number")
    private Long venueId;

    @NotNull
    @NotEmpty(message = "Attendee list cannot be empty")
    private List<Long> attendeeId;
}
