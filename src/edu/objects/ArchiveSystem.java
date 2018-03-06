package edu.objects;

import java.util.ArrayList;
import java.util.List;

public class ArchiveSystem {

    private static boolean end = false;
    private static boolean adminOnline = false;
    private static List<Admin> admins = new ArrayList<Admin>();
    private static List<SportVenue> venues = new ArrayList<SportVenue>();
    private static List<Sport> sports = new ArrayList<Sport>();
    private static List<IocCode> iocCodes = new ArrayList<IocCode>();
    private static List<Athlete> athletes = new ArrayList<Athlete>();
    private static List<Competition> competitions = new ArrayList<Competition>();

    /**
     * 
     * @return the value of the variable end
     */
    public static boolean isEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *            the value to be placed in the variable end
     */
    public static void setEnd(boolean end) {
        ArchiveSystem.end = end;
    }

    /**
     * 
     * @return the value of the variable adminOnline
     */
    public static boolean isAdminOnline() {
        return adminOnline;
    }

    /**
     * 
     * @param adminOnline
     *            the value to be placed in the variable adminOnline
     */
    public static void setAdminOnline(boolean adminOnline) {
        ArchiveSystem.adminOnline = adminOnline;
    }

    /**
     * 
     * @return the list of saved admins
     */
    public static List<Admin> getAdmins() {
        return admins;
    }

    /**
     * 
     * @return the list of sports venues
     */
    public static List<SportVenue> getVenues() {
        return venues;
    }

    /**
     * 
     * @return the list of sports
     */
    public static List<Sport> getSports() {
        return sports;
    }

    /**
     * 
     * @return the list of IOC - Codes
     */
    public static List<IocCode> getIocCodes() {
        return iocCodes;
    }

    /**
     * 
     * @return the list of Athletes
     */
    public static List<Athlete> getAthletes() {
        return athletes;
    }

    /**
     * 
     * @return the list of competitions
     */
    public static List<Competition> getCompetitions() {
        return competitions;
    }
}
