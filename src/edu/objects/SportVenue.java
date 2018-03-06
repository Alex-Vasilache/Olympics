package edu.objects;

public class SportVenue implements Comparable<SportVenue> {

    private String id;
    private String countryName;
    private String city;
    private String name;
    private int oppeningYear;
    private int seats;

    /**
     * 
     * @param id
     *            The ID of the sport venue
     * @param countryName
     *            The name of the country where the sports venue is
     * @param city
     *            The name of the city where the sports venue is
     * @param name
     *            The name of the sports venue
     * @param oppeningYear
     *            The opening year of the sports venue
     * @param seats
     *            The number of seats available in the venue
     */
    public SportVenue(String id, String countryName, String city, String name, int oppeningYear, int seats) {
        this.id = id;
        this.countryName = countryName;
        this.city = city;
        this.name = name;
        this.oppeningYear = oppeningYear;
        this.seats = seats;
    }

    /**
     * 
     * @return The ID of the sport venue
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return The name of the country where the sports venue is
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * @return The name of the city where the sports venue is
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @return The name of the sports venue
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return The opening year of the sports venue
     */
    public int getOppeningYear() {
        return oppeningYear;
    }

    /**
     * 
     * @return The number of seats available in the venue
     */
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
