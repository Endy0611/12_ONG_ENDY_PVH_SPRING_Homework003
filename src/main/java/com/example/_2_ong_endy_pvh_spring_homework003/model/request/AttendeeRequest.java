package com.example._2_ong_endy_pvh_spring_homework003.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    @NotBlank(message = "Attendee name cannot be blank")
    @NonNull
    @Size(min = 1, max = 50, message = "Attendee name must be between 1 and 50 characters")
    @Schema(example = "Endy")
    private String attendeeName;
    @NotNull
    @NotBlank(message = "Email must be a valid format (e.g., abc@gmail.com)")
    @Email(message = "Invalid email format")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+@gmail\\.com$",
            message = "Email must be a valid format (e.g., abc@gmail.com)"
    )
    @Schema(example = "endyong18@gmail.com")
    private String email;
}
