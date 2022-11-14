package jay.project.WeatherTrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jay.project.WeatherTrack.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByUserid(long userid);
}