package org.envision.trash_it;

public class Bin
{
    int Bio_percent,NonBio_percent;
    double Latitude,Longitude;
    String Place;
    int TimesFilled;
    boolean Waste_type;

    public Bin(double latitude, double longitude, String place) {
        Latitude = latitude;
        Longitude = longitude;
        Place = place;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public int getBio_percent() {
        return Bio_percent;
    }

    public int getNonBio_percent() {
        return NonBio_percent;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public String getPlace() {
        return Place;
    }

    public int getTimesFilled() {
        return TimesFilled;
    }

    public boolean isWaste_type() {
        return Waste_type;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public void setBio_percent(int bio_percent) {
        Bio_percent = bio_percent;
    }

    public void setNonBio_percent(int nonBio_percent) {
        NonBio_percent = nonBio_percent;
    }

    public void setTimesFilled(int timesFilled) {
        TimesFilled = timesFilled;
    }

    public void setWaste_type(boolean waste_type) {
        Waste_type = waste_type;
    }

    public Bin(int bio_percent, int nonBio_percent, double latitude, double longitude, String place, int timesFilled, boolean waste_type)
    {
        Bio_percent = bio_percent;
        NonBio_percent = nonBio_percent;
        Latitude = latitude;
        Longitude = longitude;
        Place = place;
        TimesFilled = timesFilled;
        Waste_type = waste_type;
    }

    public Bin() {

    }
}
