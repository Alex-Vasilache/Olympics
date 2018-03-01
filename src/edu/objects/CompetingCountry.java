package edu.objects;

public class CompetingCountry implements Comparable<CompetingCountry> {
    private IocCode iocCode;
    private int gold;
    private int silver;
    private int bronze;
    private int medals;

    public CompetingCountry(IocCode iocCode) {
        this.iocCode = iocCode;
        this.gold = 0;
        this.silver = 0;
        this.bronze = 0;
        this.medals = 0;
    }

    public IocCode getIocCode() {
        return iocCode;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = this.gold + gold;
        this.medals = this.medals + gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = this.silver + silver;
        this.medals = this.medals + silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = this.bronze + bronze;
        this.medals = this.medals + bronze;
    }

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
