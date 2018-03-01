package edu.errors;

import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;
import edu.objects.IocCode;
import edu.objects.Sport;

public class Errors {

    public static boolean addAdmin(String input) {

        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        if (ArchiveSystem.isAdminOnline()) {
            Terminal.printError("an admin is already logged in!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 3) {
            Terminal.printError(
                    "instruction must contain 4 arguments: First Name;Last Name;Username;Password!");
            return true;
        }
        String[] data = inputParts[1].split(";");
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
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 1) {
            Terminal.printError("instruction must contain 2 arguments: Username;Password!");
            return true;
        }
        String[] data = inputParts[1].split(";");
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

    public static boolean logoutAdmin(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 1) {
            Terminal.printError("the input must contain no arguments!");
            return true;
        }
        return false;
    }

    public static boolean addSportsVenue(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 5) {
            Terminal.printError("instruction must contain 6 arguments, separated by <<;>>!");
            return true;
        }
        String[] data = inputParts[1].split(";");
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
        if (Integer.parseInt(data[4]) < 1000 || Integer.parseInt(data[4]) > 9999) {
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
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 1) {
            Terminal.printError("instruction must contain 2 arguments, separated by <<;>>!");
            return true;
        }
        String[] data = inputParts[1].split(";");
        for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
            if (ArchiveSystem.getSports().get(i).getSportType().equals(data[0])
                    && ArchiveSystem.getSports().get(i).getSportDiscipline().equals(data[1])) {
                Terminal.printError("olympic sport already exists!");
                return true;
            }
        }
        return false;
    }

    public static boolean addIocCode(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 3) {
            Terminal.printError("instruction must contain 4 arguments, separated by <<;>>!");
            return true;
        }
        String[] data = inputParts[1].split(";");
        try {
            Integer.parseInt(data[0]);
        } catch (NumberFormatException e) {
            Terminal.printError("IOC_ID must be a number!");
            return true;
        }
        if (data[0].length() != 3) {
            Terminal.printError("IOC_ID must have the following form: 001, 002, ..., 999!");
            return true;
        }
        if (Integer.parseInt(data[0]) < 1 || Integer.parseInt(data[0]) > 999) {
            Terminal.printError("IOC_ID must have the following form: 001, 002, ..., 999!");
            return true;
        }
        for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
            if (ArchiveSystem.getIocCodes().get(i).getId().equals(data[0])) {
                Terminal.printError("an IOC-Code with that ID already exists!");
                return true;
            }
        }
        if (!data[1].matches("[a-z]+")) {
            Terminal.printError("IOC_Code must contain only small letters!");
            return true;
        }
        if (data[1].length() != 3) {
            Terminal.printError("IOC_Code must be 3 letters long!");
            return true;
        }
        for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
            if (ArchiveSystem.getIocCodes().get(i).getCode().equals(data[1])) {
                Terminal.printError("an IOC-Code with that Code already exists!");
                return true;
            }
        }
        try {
            Integer.parseInt(data[3]);
        } catch (NumberFormatException e) {
            Terminal.printError("Establishing Year must be a number!");
            return true;
        }
        if (data[3].length() != 4) {
            Terminal.printError("Establishing Year must be 4 characters long");
            return true;
        }
        if (Integer.parseInt(data[3]) < 1000 || Integer.parseInt(data[3]) > 9999) {
            Terminal.printError("Establishing Year must be a valid year");
            return true;
        }
        return false;
    }

    public static boolean addAthlete(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 5) {
            Terminal.printError("instruction must contain 6 arguments, separated by <<;>>!");
            return true;
        }
        String[] data = inputParts[1].split(";");
        try {
            Integer.parseInt(data[0]);
        } catch (NumberFormatException e) {
            Terminal.printError("ID must be a number!");
            return true;
        }
        if (data[0].length() != 4) {
            Terminal.printError("ID must have the following form: 0001, 0002, ..., 9999!");
            return true;
        }
        if (Integer.parseInt(data[0]) < 1 || Integer.parseInt(data[0]) > 9999) {
            Terminal.printError("ID must have the following form: 0001, 0002, ..., 9999!");
            return true;
        }
        IocCode code = null;
        for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
            if (data[3].equals(ArchiveSystem.getIocCodes().get(i).getCountryName())) {
                code = ArchiveSystem.getIocCodes().get(i);
            }
        }
        if (code == null) {
            Terminal.printError("no country with the entered name has been registred yet!");
            return true;
        }
        Sport sport = null;
        for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
            if (data[4].equals(ArchiveSystem.getSports().get(i).getSportType())
                    && data[5].equals(ArchiveSystem.getSports().get(i).getSportDiscipline())) {
                sport = ArchiveSystem.getSports().get(i);
            }
        }
        if (sport == null) {
            Terminal.printError("no sport with the entered type and discipline has been registred yet!");
            return true;
        }
        for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
            if (ArchiveSystem.getAthletes().get(i).getId().equals(data[0])
                    && (!data[1].equals(ArchiveSystem.getAthletes().get(i).getFirstName())
                            || !data[2].equals(ArchiveSystem.getAthletes().get(i).getLastName())
                            || !code.equals(ArchiveSystem.getAthletes().get(i).getIocCode()))) {
                Terminal.printError("an Athlete with that ID already exists!");
                return true;
            }
        }
        for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
            if (!ArchiveSystem.getAthletes().get(i).getId().equals(data[0])
                    && data[1].equals(ArchiveSystem.getAthletes().get(i).getFirstName())
                    && data[2].equals(ArchiveSystem.getAthletes().get(i).getLastName())
                    && code.equals(ArchiveSystem.getAthletes().get(i).getIocCode())) {
                Terminal.printError("an Athlete with that name and country already exists!");
                return true;
            }
        }
        for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
            if (ArchiveSystem.getAthletes().get(i).getId().equals(data[0])
                    && data[1].equals(ArchiveSystem.getAthletes().get(i).getFirstName())
                    && data[2].equals(ArchiveSystem.getAthletes().get(i).getLastName())
                    && code.equals(ArchiveSystem.getAthletes().get(i).getIocCode())) {
                for (int j = 0; j < ArchiveSystem.getAthletes().get(i).getSports().size(); j++) {
                    if (sport.equals(ArchiveSystem.getAthletes().get(i).getSports().get(j))) {
                        Terminal.printError("this Athlete has already been registered"
                                + " for this sport type and discipline!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean addCompetition(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        char[] parts = inputParts[1].toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 7) {
            Terminal.printError("instruction must contain 8 arguments, separated by <<;>>!");
            return true;
        }
        String[] data = inputParts[1].split(";");
        try {
            Integer.parseInt(data[0]);
        } catch (NumberFormatException e) {
            Terminal.printError("ID must be a number!");
            return true;
        }
        if (data[0].length() != 4) {
            Terminal.printError("ID must have the following form: 0001, 0002, ..., 9999!");
            return true;
        }
        if (Integer.parseInt(data[0]) < 1 || Integer.parseInt(data[0]) > 9999) {
            Terminal.printError("ID must have the following form: 0001, 0002, ..., 9999!");
            return true;
        }
        int athleteIndex = -1;
        for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
            if (ArchiveSystem.getAthletes().get(i).getId().equals(data[0])) {
                athleteIndex = i;
            }
        }
        if (athleteIndex == -1) {
            Terminal.printError("no athlete with the entered ID has been found!");
            return true;
        }
        try {
            Integer.parseInt(data[1]);
        } catch (NumberFormatException e) {
            Terminal.printError("Year must be a number!");
            return true;
        }
        if (data[1].length() != 4) {
            Terminal.printError("Year must be 4 characters long");
            return true;
        }
        if (Integer.parseInt(data[1]) < 1926 || Integer.parseInt(data[1]) > 2018
                || Integer.parseInt(data[1]) % 4 != 2) {
            Terminal.printError("Year must be a valid year");
            return true;
        }
        IocCode code = null;
        for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
            if (data[2].equals(ArchiveSystem.getIocCodes().get(i).getCountryName())) {
                code = ArchiveSystem.getIocCodes().get(i);
            }
        }
        if (code == null) {
            Terminal.printError("no country with the entered name has been registred yet!");
            return true;
        }
        if (!ArchiveSystem.getAthletes().get(athleteIndex).getIocCode().equals(code)) {
            Terminal.printError("the athlete with the entered ID does not compete for entered country!");
            return true;
        }
        Sport sport = null;
        for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
            if (data[3].equals(ArchiveSystem.getSports().get(i).getSportType())
                    && data[4].equals(ArchiveSystem.getSports().get(i).getSportDiscipline())) {
                sport = ArchiveSystem.getSports().get(i);
            }
        }
        if (sport == null) {
            Terminal.printError("no sport with the entered type and discipline has been registred yet!");
            return true;
        }
        boolean hasSport = false;
        for (int i = 0; i < ArchiveSystem.getAthletes().get(athleteIndex).getSports().size(); i++) {
            if (ArchiveSystem.getAthletes().get(athleteIndex).getSports().get(i).equals(sport)) {
                hasSport = true;
            }
        }
        if (hasSport == false) {
            Terminal.printError("the athlete with the entered ID does not compete in the entered sport!");
        }
        try {
            Integer.parseInt(data[5]);
        } catch (NumberFormatException e) {
            Terminal.printError("the number of gold medals must be a positive number!");
            return true;
        }
        if (Integer.parseInt(data[5]) < 0) {
            Terminal.printError("the number of gold medals must be a positive number!");
            return true;
        }
        try {
            Integer.parseInt(data[6]);
        } catch (NumberFormatException e) {
            Terminal.printError("the number of silver medals must be a positive number!");
            return true;
        }
        if (Integer.parseInt(data[6]) < 0) {
            Terminal.printError("the number of silver medals must be a positive number!");
            return true;
        }
        try {
            Integer.parseInt(data[7]);
        } catch (NumberFormatException e) {
            Terminal.printError("the number of bronze medals must be a positive number!");
            return true;
        }
        if (Integer.parseInt(data[7]) < 0) {
            Terminal.printError("the number of bronze medals must be a positive number!");
            return true;
        }
        return false;
    }

    public static boolean reset() {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean listSportsVenues(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        boolean foundCountry = false;
        for (int i = 0; i < ArchiveSystem.getVenues().size(); i++) {
            if (ArchiveSystem.getVenues().get(i).getCountryName().equals(inputParts[1])) {
                foundCountry = true;
                break;
            }
        }
        if (foundCountry == false) {
            Terminal.printError("no sports venues in the country with the entered name have been found!");
            return true;
        }
        return false;
    }

    public static boolean listOlympicSports(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 1) {
            Terminal.printError("the input must contain no arguments!");
            return true;
        }
        return false;
    }

    public static boolean listIocCode(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 1) {
            Terminal.printError("the input must contain no arguments!");
            return true;
        }
        return false;
    }

    public static boolean SummaryAthletes(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            Terminal.printError("the input must contain arguments!");
            return true;
        }
        boolean foundSport = false;
        for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
            if (ArchiveSystem.getSports().get(i).getSportDiscipline().equals(inputParts[1])) {
                foundSport = true;
            }
        }
        if (foundSport == false) {
            Terminal.printError("no sport with the entered discipline has been found!");
            return true;
        }
        return false;
    }

    public static boolean OlympicMedalTable(String input) {
        if (ArchiveSystem.isAdminOnline() == false) {
            Terminal.printError("no admin is logged in!");
            return true;
        }
        String[] inputParts = input.split(" ");
        if (inputParts.length != 1) {
            Terminal.printError("the input must contain no arguments!");
            return true;
        }
        return false;
    }

}
