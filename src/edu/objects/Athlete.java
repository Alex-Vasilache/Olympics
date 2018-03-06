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

    /**
     * 
     * @param id
     *            the ID of the athlete
     * @param firstName
     *            First name of the athlete
     * @param lastName
     *            Last name of the athlete
     * @param iocCode
     *            IOC - Code class respective for the country of the athlete
     * @param sport
     *            the sport class in which the athlete competes
     */
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

    /**
     * 
     * @return the ID of the athlete
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return the First Name of the athlete
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return the Last Name of the athlete
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @return the IOC - Code class respective for the country of the athlete
     */
    public IocCode getIocCode() {
        return iocCode;
    }

    /**
     * 
     * @return the list of Sports in which the athlete competes
     */
    public List<Sport> getSports() {
        return sports;
    }

    /**
     * 
     * @return the number of gold medals
     */
    public int getGold() {
        return gold;
    }

    /**
     * 
     * @param gold
     *            the number of gold medals to be added
     */
    public void setGold(String gold) {
        this.gold = Integer.parseInt(gold) + this.gold;
        this.medals = this.medals + Integer.parseInt(gold);
    }

    /**
     * 
     * @return the number of silver medals
     */
    public int getSilver() {
        return silver;
    }

    /**
     * 
     * @param silver
     *            the number of silver medals to be added
     */
    public void setSilver(String silver) {
        this.silver = Integer.parseInt(silver) + this.silver;
        this.medals = this.medals + Integer.parseInt(silver);
    }

    /**
     * 
     * @return the number of bronze medals
     */
    public int getBronze() {
        return bronze;
    }

    /**
     * 
     * @param bronze
     *            the number of bronze medals to be added
     */
    public void setBronze(String bronze) {
        this.bronze = Integer.parseInt(bronze) + this.bronze;
        this.medals = this.medals + Integer.parseInt(bronze);
    }

    /**
     * 
     * @return the total number of medals
     */
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
