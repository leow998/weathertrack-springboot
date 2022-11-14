package jay.project.WeatherTrack.entity;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private long id;

    @Column(name = "location_name")
    private String name;

    @Column(name = "location_coordinates")
    private String coordinates;

    @Column(name = "user_id")
    private long userid;

    public Location() {}

    public Location(String name, String coordinates, long userid) {
        this.name = name;
        this.coordinates = coordinates;
        this.userid = userid;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public long getUserid() {
        return userid;
    }
}