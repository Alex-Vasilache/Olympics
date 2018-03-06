package edu.logic;

import edu.errors.Errors;
import edu.kit.informatik.Terminal;
import edu.objects.Admin;
import edu.objects.ArchiveSystem;
import edu.objects.Athlete;
import edu.objects.Competition;
import edu.objects.IocCode;
import edu.objects.Sport;
import edu.objects.SportVenue;

public class Instructions {

    /**
     * If no errors are found, the method adds a new admin to the database
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void addAdmin(String input) {
        if (Errors.addAdmin(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            Admin a = new Admin(data[0], data[1], data[2], data[3]);
            ArchiveSystem.getAdmins().add(a);
            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, the method logs in an admin
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void loginAdmin(String input) {
        if (Errors.loginAdmin(input) == false) {
            ArchiveSystem.setAdminOnline(true);
            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, the current admin is logged out
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void logoutAdmin(String input) {
        if (Errors.logoutAdmin(input) == false) {
            ArchiveSystem.setAdminOnline(false);
            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, a new sports venue is added to the database
     * 
     * @param input
     *            represents the line entered by the user
     */
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

    /**
     * If no errors are found, a new sport is added to the database
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void addOlympicSport(String input) {
        if (Errors.addOlympicSport(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            Sport s = new Sport(data[0], data[1]);
            ArchiveSystem.getSports().add(s);
            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, a new IOC - Code is added to the database
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void addIocCode(String input) {
        if (Errors.addIocCode(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            IocCode i = new IocCode(data[0], data[1], data[2], Integer.parseInt(data[3]));
            ArchiveSystem.getIocCodes().add(i);
            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, a new athlete is added to the database. In case
     * the athlete with the entered ID already exists and the input contains a
     * different sport, then, the new sport is added to the existing athlete
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void addAthlete(String input) {
        if (Errors.addAthlete(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            IocCode code = null;
            for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
                if (data[3].equals(ArchiveSystem.getIocCodes().get(i).getCountryName())) {
                    code = ArchiveSystem.getIocCodes().get(i);
                }
            }
            Sport sport = null;
            for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
                if (data[4].equals(ArchiveSystem.getSports().get(i).getSportType())
                        && data[5].equals(ArchiveSystem.getSports().get(i).getSportDiscipline())) {
                    sport = ArchiveSystem.getSports().get(i);
                }
            }
            boolean foundAthlete = false;
            for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
                if (data[0].equals(ArchiveSystem.getAthletes().get(i).getId())
                        && data[1].equals(ArchiveSystem.getAthletes().get(i).getFirstName())
                        && data[2].equals(ArchiveSystem.getAthletes().get(i).getLastName())
                        && code.equals(ArchiveSystem.getAthletes().get(i).getIocCode())) {
                    ArchiveSystem.getAthletes().get(i).getSports().add(sport);
                    foundAthlete = true;
                }
            }
            if (foundAthlete == false) {
                Athlete a = new Athlete(data[0], data[1], data[2], code, sport);
                ArchiveSystem.getAthletes().add(a);
            }

            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, a new competition is added to the database
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void addCompetition(String input) {
        if (Errors.addCompetition(input) == false) {
            String[] inputParts = input.split(" ");
            String[] data = inputParts[1].split(";");
            Athlete athlete = null;
            for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
                if (data[0].equals(ArchiveSystem.getAthletes().get(i).getId())) {
                    athlete = ArchiveSystem.getAthletes().get(i);
                    ArchiveSystem.getAthletes().get(i).setGold(data[5]);
                    ArchiveSystem.getAthletes().get(i).setSilver(data[6]);
                    ArchiveSystem.getAthletes().get(i).setBronze(data[7]);
                }
            }
            Sport sport = null;
            for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
                if (data[3].equals(ArchiveSystem.getSports().get(i).getSportType())
                        && data[4].equals(ArchiveSystem.getSports().get(i).getSportDiscipline())) {
                    sport = ArchiveSystem.getSports().get(i);
                }
            }
            Competition c = new Competition(athlete, data[1], sport, data[5], data[6], data[7]);
            ArchiveSystem.getCompetitions().add(c);
            Terminal.printLine("OK");
        }
    }

    /**
     * If no errors are found, the database is reset
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void reset(String input) {
        if (Errors.reset(input) == false) {
            ArchiveSystem.getVenues().clear();
            ArchiveSystem.getSports().clear();
            ArchiveSystem.getIocCodes().clear();
            ArchiveSystem.getAthletes().clear();
            ArchiveSystem.getCompetitions().clear();
            Terminal.printLine("OK");
        }
    }

}
