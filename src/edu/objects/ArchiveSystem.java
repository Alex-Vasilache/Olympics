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

    public static boolean isEnd() {
        return end;
    }

    public static void setEnd(boolean end) {
        ArchiveSystem.end = end;
    }

    public static boolean isAdminOnline() {
        return adminOnline;
    }

    public static void setAdminOnline(boolean adminOnline) {
        ArchiveSystem.adminOnline = adminOnline;
    }

    public static List<Admin> getAdmins() {
        return admins;
    }

    public static List<SportVenue> getVenues() {
        return venues;
    }

    public static List<Sport> getSports() {
        return sports;
    }

    public static List<IocCode> getIocCodes() {
        return iocCodes;
    }
}
