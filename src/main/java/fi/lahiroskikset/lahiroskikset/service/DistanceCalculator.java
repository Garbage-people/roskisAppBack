package fi.lahiroskikset.lahiroskikset.service;

import fi.lahiroskikset.lahiroskikset.domain.Trashcan;

public class DistanceCalculator {

    public static double calculateDistance(Trashcan t1, Trashcan t2) {
        double x1 = t1.getLon();
        double y1 = t1.getLat();
        double x2 = t2.getLon();
        double y2 = t2.getLat();
        // Using the distance formula: AB = sqrt((x₂ - x₁)² + (y₂ - y₁)²)
        double squaredDistance = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        return Math.sqrt(squaredDistance);
    }
}
