package com.example._2_ong_endy_pvh_spring_homework003.service.impl;

import com.example._2_ong_endy_pvh_spring_homework003.exception.DuplicateUserException;
import com.example._2_ong_endy_pvh_spring_homework003.exception.NotFoundException;
import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Venue;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.VenueRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework003.repository.VenueRepository;
import com.example._2_ong_endy_pvh_spring_homework003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;


    @Override
    public List<Venue> getAllVenues(int page, int size) {
        int offset = size * (page-1);
        return venueRepository.getAllVenues(offset, size);
    }

    @Override
    public Venue getVenueById(Long venueId) {
        Venue venue = venueRepository.getVenueById(venueId);
        if (venue == null ) {
            throw new NotFoundException("Venue with id " + venueId + " not found");
        }
        return venue;
    }

    @Override
    public Venue deleteVenueById(Long venueId) {
        Venue venue = venueRepository.getVenueById(venueId);
        if (venue == null ) {
            throw new NotFoundException("Venue with id " + venueId + " not found");
        }
        return venueRepository.deleteVenueById(venueId);
    }

    @Override
    public Venue saveVenue(VenueRequest venueRequest) {
        if (venueRepository.existsByAttendeeName(venueRequest.getVenueName())) {
            throw new DuplicateUserException("Attendee name already exists");
        }
        return venueRepository.saveVenue(venueRequest);
    }

    @Override
    public Venue updateVenueById(Long venueId, VenueRequest venueRequest) {
        Venue venue = venueRepository.getVenueById(venueId);
        if (venue == null ) {
            throw new NotFoundException("Venue with id " + venueId + " not found");
        }
        if (venueRepository.existsByAttendeeName(venueRequest.getVenueName())) {
            throw new DuplicateUserException("Attendee name already exists");
        }
        return venueRepository.updateVenueById(venueId,venueRequest);
    }
}
