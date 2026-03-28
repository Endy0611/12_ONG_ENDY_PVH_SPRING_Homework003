package com.example._2_ong_endy_pvh_spring_homework003.controller;

import com.example._2_ong_endy_pvh_spring_homework003.model.entity.Venue;
import com.example._2_ong_endy_pvh_spring_homework003.model.request.VenueRequest;
import com.example._2_ong_endy_pvh_spring_homework003.model.response.ApiResponse;
import com.example._2_ong_endy_pvh_spring_homework003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
    private final VenueService venueService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        ApiResponse<List<Venue>> apiResponse = ApiResponse.<List<Venue>>builder()
                .timestamp(Instant.now())
                .message("Retrieved venues successfully")
                .status(HttpStatus.OK)
                .payload(venueService.getAllVenues(page, size))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{venue_id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable("venue_id") Long venueId) {
        ApiResponse<Venue> apiResponse = ApiResponse.<Venue>builder()
                .timestamp(Instant.now())
                .message(String.format("Retrieved venue with id %d successfully", venueId))
                .status(HttpStatus.OK)
                .payload(venueService.getVenueById(venueId))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{venue_id}")
    public ResponseEntity<ApiResponse<Venue>> deleteVenueById(@PathVariable("venue_id") Long venueId) {
        ApiResponse<Venue> apiResponse = ApiResponse.<Venue>builder()
                .timestamp(Instant.now())
                .message(String.format("Retrieved venue with id %d successfully", venueId))
                .status(HttpStatus.OK)
                .payload(venueService.deleteVenueById(venueId))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> saveVenue(@RequestBody VenueRequest venueRequest) {
        ApiResponse<Venue> apiResponse = ApiResponse.<Venue>builder()
                .timestamp(Instant.now())
                .message("Created venue successfull")
                .status(HttpStatus.CREATED)
                .payload(venueService.saveVenue(venueRequest))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{venue_id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable("venue_id") Long venueId, @RequestBody VenueRequest venueRequest) {
        ApiResponse<Venue> apiResponse = ApiResponse.<Venue>builder()
                .timestamp(Instant.now())
                .message(String.format("Retrieved venue with id %d successfully", venueId))
                .status(HttpStatus.OK)
                .payload(venueService.updateVenueById(venueId, venueRequest))
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
