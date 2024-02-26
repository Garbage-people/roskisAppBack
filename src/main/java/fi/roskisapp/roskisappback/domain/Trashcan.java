package fi.roskisapp.roskisappback.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trashcan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double lat;
    private double lon;

    private List<String> images;
    
    // Constructors

    public Trashcan() {
        this.lat = 0;
        this.lon = 0;
        this.images = null;
    }
    
    public Trashcan(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        this.images = null;
    }
    
    // Getters and Setters
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public List<String> getImages() {
        return images;
    }

    // Propably not needed for day to day usage, database may need it
    // Use the add single image method instead
    public void setImages(List<String> images) {
        this.images = images;
    }

    
    // ToString, no list of the images
    
    @Override
    public String toString() {
        return "Thrashcan [id=" + id + ", lon=" + lon + ", lat=" + lat + "]";
    }

    // Methods

    public void addImage(String imageURL) {
        this.images.add(imageURL);
    }
    
}