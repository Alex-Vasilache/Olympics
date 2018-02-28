package edu.logic;

import edu.errors.Errors;
import edu.kit.informatik.Terminal;
import edu.objects.Admin;
import edu.objects.ArchiveSystem;
import edu.objects.IocCode;
import edu.objects.Sport;
import edu.objects.SportVenue;

public class Instructions {

    public static void addAdmin(String input) {
        if (Errors.addAdmin(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            Admin a = new Admin(data[0], data[1], data[2], data[3]);
            ArchiveSystem.getAdmins().add(a);
            Terminal.printLine("OK");
        }
    }

    public static void loginAdmin(String input) {
        if (Errors.loginAdmin(input) == false) {
            ArchiveSystem.setAdminOnline(true);
            Terminal.printLine("OK");
        }
    }

    public static void logoutAdmin(String input) {
        if (Errors.logoutAdmin(input) == false) {
            ArchiveSystem.setAdminOnline(false);
            Terminal.printLine("OK");
        }
    }

    public static void addSportsVenue(String input) {
        if (Errors.addSportsVenue(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            SportVenue s = new SportVenue(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]));
            ArchiveSystem.getVenues().add(s);
            Terminal.printLine("OK");
        }
    }

    public static void addOlympicSport(String input) {
        if (Errors.addOlympicSport(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            Sport s = new Sport(data[0], data[1]);
            ArchiveSystem.getSports().add(s);
            Terminal.printLine("OK");
        }
    }

    public static void addIocCode(String input) {
        if (Errors.addIocCode(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            IocCode i = new IocCode(data[0], data[1], data[2], Integer.parseInt(data[3]));
            ArchiveSystem.getIocCodes().add(i);
            Terminal.printLine("OK");
        }
    }

    public static void addAthlete(String input) {
        if (Errors.addAthlete(input) == false) {
            // TODO Auto-generated method stub
        } else {
            // TODO PRINT ERROR
        }
    }

    public static void addCompetition(String input) {
        if (Errors.addCompetition(input) == false) {
            // TODO Auto-generated method stub
        } else {
            // TODO PRINT ERROR
        }
    }

    public static void reset() {
        if (Errors.reset() == false) {
            // TODO Auto-generated method stub
        } else {
            // TODO PRINT ERROR
        }
    }

}
