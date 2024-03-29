package fi.lahiroskikset.lahiroskikset.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("trashcans")
public class Trashcan {

    
    @Id
    private String id;

    private double lat;
    private double lon;

    // The first string is a status code where 0=available (default), 1=full, 2=out of order
    private String[] status = { "", "" };

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String[] getStatus() {
        return Arrays.copyOf(status, status.length);
    }

    public void setStatus(String statusCode, String statusDate) {
        this.status[0] = statusCode;
        this.status[1] = statusDate;
    }

    // ToString, no list of the images

    @Override
    public String toString() {
        return "Thrashcan [id=" + id + ", lon=" + lon + ", lat=" + lat + ", statusCode=" + status[0] + ", statusDate="
                + status[1] + "]";
    }

    // Methods

    public void addImage(String imageURL) {
        this.images.add(imageURL);
    }

}