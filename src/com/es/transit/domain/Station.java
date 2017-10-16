package com.es.transit.domain;

public class Station {

    private String id;

    private String name;

    private double latitude;

    private double longitude;

    private int zone;

    private String url;

    private int type;

    private int parentId;

    private boolean isWheelchairAccessible;

    public Station() {
    }


    public Station(String... items) {
        this(items[0], items[1], Double.parseDouble(items[2]),
                Double.parseDouble(items[3]), Integer.parseInt(items[4]), items[5],
                Integer.parseInt(items[6]), Integer.parseInt(items[7].trim().equals("") ? "0" : items[7].trim()), items[8].equals("1"));

    }
    public Station(String id, String name, double latitude, double longitude, int zone, String url, int type, int parentId, boolean isWheelchairAccessible) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.url = url;
        this.type = type;
        this.parentId = parentId;
        this.isWheelchairAccessible = isWheelchairAccessible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        isWheelchairAccessible = wheelchairAccessible;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", zone=" + zone +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", parentId=" + parentId +
                ", isWheelchairAccessible=" + isWheelchairAccessible +
                '}';
    }
}

