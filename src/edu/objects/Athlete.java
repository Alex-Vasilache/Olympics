package edu.objects;

import java.util.ArrayList;
import java.util.List;

public class Athlete implements Comparable<Athlete> {

    private String id;
    private String firstName;
    private String lastName;
    private IocCode iocCode;
    private List<Sport> sports = new ArrayList<Sport>();
    private int gold;
    private int silver;
    private int bronze;
    private int medals;

    public Athlete(String id, String firstName, String lastName, IocCode iocCode, Sport sport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.iocCode = iocCode;
        this.sports.add(sport);
        this.setGold("0");
        this.setSilver("0");
        this.setBronze("0");
        this.medals = 0;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public IocCode getIocCode() {
        return iocCode;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = Integer.parseInt(gold) + this.gold;
        this.medals = this.medals + Integer.parseInt(gold);
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = Integer.parseInt(silver) + this.silver;
        this.medals = this.medals + Integer.parseInt(silver);
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(String bronze) {
        this.bronze = Integer.parseInt(bronze) + this.bronze;
        this.medals = this.medals + Integer.parseInt(bronze);
    }

    public int getMedals() {
        return medals;
    }

    @Override
    public int compareTo(Athlete a) {
        if (this.getMedals() < a.getMedals()) {
            return 1;
        } else if (this.getMedals() > a.getMedals()) {
            return -1;
        } else {
            if (Integer.parseInt(this.getId()) < Integer.parseInt(a.getId())) {
                return -1;
            } else if (Integer.parseInt(this.getId()) > Integer.parseInt(a.getId())) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
