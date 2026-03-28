package com.example._2_ong_endy_pvh_spring_homework003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    private Long venueId;
    private String venueName;
    private String location;
}
