package fi.roskisapp.roskisappback.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Thrashcan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double lon;

    private double lat;

    private List<String> images;
    
    // Constructors
    
    public Thrashcan(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
        this.images = null;
    }
    
    // Getters and Setters

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
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
