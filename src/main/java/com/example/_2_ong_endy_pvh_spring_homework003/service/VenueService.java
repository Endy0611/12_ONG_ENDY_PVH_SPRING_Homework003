package com.example._2_ong_endy_pvh_spring_homework003.service;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Venue;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.VenueRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues(int page, int size);

    Venue getVenueById(Long venueId);

    Venue deleteVenueById(Long venueId);

    Venue saveVenue(VenueRequest venueRequest);

    Venue updateVenueById(Long venueId, VenueRequest venueRequest);
}
