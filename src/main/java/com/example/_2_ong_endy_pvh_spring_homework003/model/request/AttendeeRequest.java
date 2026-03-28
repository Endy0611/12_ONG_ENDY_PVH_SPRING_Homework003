package com.example._2_ong_endy_pvh_spring_homework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    private String attendeeName;
    private String email;
}
