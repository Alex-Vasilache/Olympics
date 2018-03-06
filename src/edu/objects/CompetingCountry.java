package edu.objects;

public class CompetingCountry implements Comparable<CompetingCountry> {
    private IocCode iocCode;
    private int gold;
    private int silver;
    private int bronze;
    private int medals;

    /**
     * 
     * @param iocCode
     *            The IOC - Code class of the competing country
     */
    public CompetingCountry(IocCode iocCode) {
        this.iocCode = iocCode;
        this.gold = 0;
        this.silver = 0;
        this.bronze = 0;
        this.medals = 0;
    }

    /**
     * 
     * @return the IOC - Code class of the competing country
     */
    public IocCode getIocCode() {
        return iocCode;
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
    public void setGold(int gold) {
        this.gold = this.gold + gold;
        this.medals = this.medals + gold;
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
    public void setSilver(int silver) {
        this.silver = this.silver + silver;
        this.medals = this.medals + silver;
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
    public void setBronze(int bronze) {
        this.bronze = this.bronze + bronze;
        this.medals = this.medals + bronze;
    }

    /**
     * 
     * @return the total number of medals
     */
    public int getMedals() {
        return medals;
    }

    @Override
    public int compareTo(CompetingCountry c) {
        if (this.getGold() < c.getGold()) {
            return 1;
        } else if (this.getGold() > c.getGold()) {
            return -1;
        } else {
            if (this.getSilver() < c.getSilver()) {
                return 1;
            } else if (this.getSilver() > c.getSilver()) {
                return -1;
            } else {
                if (this.getBronze() < c.getBronze()) {
                    return 1;
                } else if (this.getBronze() > c.getBronze()) {
                    return -1;
                } else {
                    if (Integer.parseInt(this.getIocCode().getId()) < Integer
                            .parseInt(c.getIocCode().getId())) {
                        return -1;
                    } else if (Integer.parseInt(this.getIocCode().getId()) > Integer
                            .parseInt(c.getIocCode().getId())) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}
