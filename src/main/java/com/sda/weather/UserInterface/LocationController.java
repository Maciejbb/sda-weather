package com.sda.weather.location;

import com.sda.weather.UserInterface.LocationDTO;
import com.sda.weather.UserInterface.LocationMapper;
import com.sda.weather.UserInterface.LocationService;
import com.sda.weather.UserInterface.ObjectMapper;
import lombok.RequiredArgsConstructor;

import javax.xml.stream.Location;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LocationController {

    private final ObjectMapper objectMapper;
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    public String createLocation(String city, String region, String country, String longitude, String latitude) {
        try {
            Location location = locationService.createLocation(city, region, country, longitude, latitude);
            LocationDTO locationDTO = locationMapper.asLocationDTO(location);
            return objectMapper.writeValueAsString(locationDTO);
        } catch (Exception e) {
            return String.format("{\"status\": \"error\", \"message\": \"%s\"}", e.getMessage());
        }
    }

    public String getLocations() {
        try {
            List<LocationDTO> locations = locationService.getLocations().stream()
                    .map(locationMapper::asLocationDTO)
                    .collect(Collectors.toList());

            return objectMapper.writeValueAsString(locations);
        } catch (Exception e) {
            return String.format("{\"status\": \"error\", \"message\": \"%s\"}", e.getMessage());
        }
    }
}
