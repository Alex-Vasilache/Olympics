package edu.errors;

import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;
import edu.objects.IocCode;
import edu.objects.Sport;

public class Errors2 {

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
    public static boolean addCompetition1(String input) {
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
        return false;
    }

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
    public static boolean addCompetition2(String input) {

        String[] inputParts = input.split(" ");
        String[] data = inputParts[1].split(";");
        int athleteIndex = 0;
        for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
            if (ArchiveSystem.getAthletes().get(i).getId().equals(data[0])) {
                athleteIndex = i;
            }
        }
        IocCode code = null;
        for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
            if (data[2].equals(ArchiveSystem.getIocCodes().get(i).getCountryName())) {
                code = ArchiveSystem.getIocCodes().get(i);
            }
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
        return false;
    }

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
    public static boolean addCompetition3(String input) {

        String[] inputParts = input.split(" ");
        String[] data = inputParts[1].split(";");
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
        for (int i = 0; i < ArchiveSystem.getCompetitions().size(); i++) {
            if (ArchiveSystem.getCompetitions().get(i).getAthlete().getId().equals(data[0])
                    && ArchiveSystem.getCompetitions().get(i).getYear() == Integer.parseInt(data[1])
                    && ArchiveSystem.getCompetitions().get(i).getAthlete().getIocCode().getCountryName()
                            .equals(data[2])
                    && ArchiveSystem.getCompetitions().get(i).getSport().getSportType().equals(data[3])
                    && ArchiveSystem.getCompetitions().get(i).getSport().getSportDiscipline()
                            .equals(data[4])) {
                Terminal.printError("an athlete can only compete once in the same year for a Sport!");
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
    public static boolean reset(String input) {
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

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
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
        for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
            if (ArchiveSystem.getIocCodes().get(i).getCountryName().equals(inputParts[1])) {
                foundCountry = true;
                break;
            }
        }
        if (foundCountry == false) {
            Terminal.printError("no countries with that name have been added!");
            return true;
        }
        foundCountry = false;
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

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
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

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
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

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
    public static boolean summaryAthletes(String input) {
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
        boolean foundSport = false;
        for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
            if (ArchiveSystem.getSports().get(i).getSportType().equals(data[0])
                    && ArchiveSystem.getSports().get(i).getSportDiscipline().equals(data[1])) {
                foundSport = true;
            }
        }
        if (foundSport == false) {
            Terminal.printError("no sport with the entered type and discipline has been found!");
            return true;
        }
        return false;
    }

    /**
     * 
     * @param input
     *            represents the line entered by the user
     * @return true, if errors have been found for the respective instruction
     *         and false instead
     */
    public static boolean olympicMedalTable(String input) {
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
