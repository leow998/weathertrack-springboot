package jay.project.WeatherTrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jay.project.WeatherTrack.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}