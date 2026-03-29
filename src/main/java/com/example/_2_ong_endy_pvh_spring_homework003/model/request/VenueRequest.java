package com.example._2_ong_endy_pvh_spring_homework003.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotNull
    @NotBlank(message = "Venue name cannot be blank")
    @Size(min = 1, max = 100, message = "Venue name must not exceed 100 characters")
    private String venueName;
    @NotNull
    @NotBlank(message = "Location cannot be blank")
    @Size(min = 1, max = 150, message = "Location must not exceed 150 characters")
    private String location;
}
