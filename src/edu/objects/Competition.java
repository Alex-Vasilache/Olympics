package edu.objects;

public class Competition {
    private Athlete athlete;
    private int year;
    private Sport sport;
    private int gold;
    private int silver;
    private int bronze;

    public Competition(Athlete athlete, String year, Sport sport, String gold, String silver, String bronze) {
        this.athlete = athlete;
        this.year = Integer.parseInt(year);
        this.sport = sport;
        this.gold = Integer.parseInt(gold);
        this.silver = Integer.parseInt(silver);
        this.bronze = Integer.parseInt(bronze);
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public int getYear() {
        return year;
    }

    public Sport getSport() {
        return sport;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }
}
