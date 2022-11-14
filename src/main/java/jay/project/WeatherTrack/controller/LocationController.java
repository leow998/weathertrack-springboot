package jay.project.WeatherTrack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jay.project.WeatherTrack.entity.Location;
import jay.project.WeatherTrack.repository.LocationRepository;

@CrossOrigin(origins = {"https://weathertrack-angular.herokuapp.com/", "http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    // API for selecting all locations saved by a user
    @GetMapping("/locations/{user_id}")
    public ResponseEntity<List<Location>> getAllLocations(@PathVariable("user_id") long userid) {
        try {
            List<Location> locations = new ArrayList<Location>();

            locationRepository.findByUserid(userid).forEach(locations::add);

            if (locations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // API for creating new location
    @PostMapping("/locations")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        try {
            Location _location = locationRepository.save(new Location(
                location.getName(), location.getCoordinates(), location.getUserid()));
            return new ResponseEntity<>(_location, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // API for removing location
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<HttpStatus> deleteLocation(@PathVariable("id") long id) {
        try {
            locationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}