package edu.objects;

public class SportVenue implements Comparable<SportVenue> {

    private String id;
    private String countryName;
    private String city;
    private String name;
    private int oppeningYear;
    private int seats;

    public SportVenue(String id, String countryName, String city, String name, int oppeningYear, int seats) {
        this.id = id;
        this.countryName = countryName;
        this.city = city;
        this.name = name;
        this.oppeningYear = oppeningYear;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getOppeningYear() {
        return oppeningYear;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public int compareTo(SportVenue s) {
        if (this.getSeats() < s.getSeats()) {
            return -1;
        } else if (this.getSeats() > s.getSeats()) {
            return 1;
        } else {
            if (Integer.parseInt(this.getId()) < Integer.parseInt(s.getId())) {
                return -1;
            } else if (Integer.parseInt(this.getId()) > Integer.parseInt(s.getId())) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
