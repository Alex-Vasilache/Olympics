package edu.objects;

public class Sport implements Comparable<Sport> {
    private String sportType;
    private String sportDiscipline;

    /**
     * 
     * @param sportType
     *            the type of the sport
     * @param sportDiscipline
     *            the discipline of the sport
     */
    public Sport(String sportType, String sportDiscipline) {
        this.sportType = sportType;
        this.sportDiscipline = sportDiscipline;
    }

    /**
     * 
     * @return the type of the sport
     */
    public String getSportType() {
        return sportType;
    }

    /**
     * 
     * @return the discipline of the sport
     */
    public String getSportDiscipline() {
        return sportDiscipline;
    }

    @Override
    public int compareTo(Sport s) {
        if (this.getSportType().compareTo(s.getSportType()) < 0) {
            return -1;
        } else if (this.getSportType().compareTo(s.getSportType()) > 0) {
            return 1;
        } else {
            if (this.getSportDiscipline().compareTo(s.getSportDiscipline()) < 0) {
                return -1;
            } else if (this.getSportDiscipline().compareTo(s.getSportDiscipline()) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
