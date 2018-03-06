package edu.objects;

public class Competition {
    private Athlete athlete;
    private int year;
    private Sport sport;
    private int gold;
    private int silver;
    private int bronze;

    /**
     * 
     * @param athlete
     *            The class of the competing athlete
     * @param year
     *            The year in which the competition took place
     * @param sport
     *            The class of the sport of the competition
     * @param gold
     *            The number of gold medals won
     * @param silver
     *            The number of silver medals won
     * @param bronze
     *            The number of bronze medals won
     */
    public Competition(Athlete athlete, String year, Sport sport, String gold, String silver, String bronze) {
        this.athlete = athlete;
        this.year = Integer.parseInt(year);
        this.sport = sport;
        this.gold = Integer.parseInt(gold);
        this.silver = Integer.parseInt(silver);
        this.bronze = Integer.parseInt(bronze);
    }

    /**
     * 
     * @return The class of the competing athlete
     */
    public Athlete getAthlete() {
        return athlete;
    }

    /**
     * 
     * @return The year in which the competition took place
     */
    public int getYear() {
        return year;
    }

    /**
     * 
     * @return The class of the sport of the competition
     */
    public Sport getSport() {
        return sport;
    }

    /**
     * 
     * @return The number of gold medals won
     */
    public int getGold() {
        return gold;
    }

    /**
     * 
     * @return The number of silver medals won
     */
    public int getSilver() {
        return silver;
    }

    /**
     * 
     * @return The number of bronze medals won
     */
    public int getBronze() {
        return bronze;
    }
}
