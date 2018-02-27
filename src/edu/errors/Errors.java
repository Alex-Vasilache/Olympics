package edu.errors;

import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;

public class Errors {

    public static boolean addAdmin(String input) {

        if (ArchiveSystem.isAdminOnline()) {
            Terminal.printError("an admin is already logged in!");
            return true;
        }
        char[] parts = input.toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 3) {
            Terminal.printError(
                    "instruction must contain 4 arguments: First Name, Last Name, Username and Password!");
            return true;
        }
        String[] data = input.split(";");
        if (data[2].length() < 4 || data[2].length() > 8) {
            Terminal.printError("username must have between 4 and 8 characters!");
            return true;
        }
        if (data[3].length() < 8 || data[3].length() > 12) {
            Terminal.printError("password must have between 8 and 12 characters!");
            return true;
        }
        for (int i = 0; i < ArchiveSystem.getAdmins().size(); i++) {
            if (ArchiveSystem.getAdmins().get(i).getUserName().equals(data[2])) {
                Terminal.printError("an admin with that username already exists!");
                return true;
            }
        }
        return false;
    }

    public static boolean loginAdmin(String input) {
        if (ArchiveSystem.isAdminOnline()) {
            Terminal.printError("an admin is already logged in!");
            return true;
        }
        char[] parts = input.toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 1) {
            Terminal.printError("instruction must contain 2 arguments: Username and Password!");
            return true;
        }
        String[] data = input.split(";");
        boolean userExists = false;
        for (int i = 0; i < ArchiveSystem.getAdmins().size(); i++) {
            if (ArchiveSystem.getAdmins().get(i).getUserName().equals(data[0])) {
                userExists = true;
                if (ArchiveSystem.getAdmins().get(i).getPassword().equals(data[1]) == false) {
                    Terminal.printError("wrong password!");
                    return true;
                }
            }
        }
        if (userExists == false) {
            Terminal.printError("username not found!");
            return true;
        }
        return false;
    }

    public static boolean logoutAdmin() {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        return false;
    }

    public static boolean addSportsVenue(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        char[] parts = input.toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 5) {
            Terminal.printError("instruction must contain 6 arguments!");
            return true;
        }
        String[] data = input.split(";");
        try {
            Integer.parseInt(data[0]);
        } catch (NumberFormatException e) {
            Terminal.printError("ID must be a number!");
            return true;
        }
        if (data[0].length() != 3) {
            Terminal.printError("ID must have the following form: 001, 002, ..., 999!");
            return true;
        }
        if (Integer.parseInt(data[0]) < 1 || Integer.parseInt(data[0]) > 999) {
            Terminal.printError("ID must have the following form: 001, 002, ..., 999!");
            return true;
        }
        for (int i = 0; i < ArchiveSystem.getVenues().size(); i++) {
            if (ArchiveSystem.getVenues().get(i).getId().equals(data[0])) {
                Terminal.printError("a sports venue with that ID already exists!");
                return true;
            }
        }
        try {
            Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            Terminal.printError("Oppening Year must be a number!");
            return true;
        }
        if (data[4].length() != 4) {
            Terminal.printError("Oppening Year must be 4 characters long");
            return true;
        }
        if (Integer.parseInt(data[4]) < 1000 || Integer.parseInt(data[0]) > 9999) {
            Terminal.printError("Oppening Year must be a valid year");
            return true;
        }
        try {
            Integer.parseInt(data[5]);
        } catch (NumberFormatException e) {
            Terminal.printError("Number of Seats must be a number!");
            return true;
        }
        return false;
    }

    public static boolean addOlympicSport(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean addIocCode(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean addAthlete(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean addCompetition(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean reset() {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean listSportsVenues(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean listOlympicSports(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean listIocCode(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean SummaryAthletes(String input) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean OlympicMedalTable(String input) {
        // TODO Auto-generated method stub
        return false;
    }

}
