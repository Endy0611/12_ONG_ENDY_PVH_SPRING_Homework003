package com.example._2_ong_endy_pvh_spring_homework003.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "HRD Center Party")
    private String eventName;

    @NotNull(message = "Event date is required")
    @Schema(example = "2026-03-30")
    private LocalDate eventDate;

    @NotNull
    @NotNull(message = "Venue ID is required")
    @Positive(message = "Venue ID must be positive number")
    @Schema(example = "88889999")
    private Long venueId;

    @NotNull
    @NotEmpty(message = "Attendee list cannot be empty")
    @Schema(example = "[99991111]")
    private List<Long> attendeeId;
}
