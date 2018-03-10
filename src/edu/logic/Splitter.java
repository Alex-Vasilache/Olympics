package edu.logic;

import edu.io.Print;
import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;

public class Splitter {

    /**
     * Splits the inputed line and checks if the first word matches the
     * instructions, in which case it tries to run that instruction. In case the
     * instruction did not match any of the standard instructions, an error will
     * be given
     * 
     * @param input
     *            represents the line entered by the user
     */
    public static void split(String input) {
        String[] parts = input.split(" ");
        switch (parts[0]) {
        case "add-admin": {
            Instructions.addAdmin(input);
            break;
        }
        case "login-admin": {
            Instructions.loginAdmin(input);
            break;
        }
        case "logout-admin": {
            Instructions.logoutAdmin(input);
            break;
        }
        case "add-sports-venue": {
            Instructions.addSportsVenue(input);
            break;
        }
        case "list-sports-venues": {
            Print.listSportsVenues(input);
            break;
        }
        case "add-olympic-sport": {
            Instructions.addOlympicSport(input);
            break;
        }
        case "list-olympic-sports": {
            Print.listOlympicSports(input);
            break;
        }
        case "add-ioc-code": {
            Instructions.addIocCode(input);
            break;
        }
        case "list-ioc-codes": {
            Print.listIocCode(input);
            break;
        }
        case "add-athlete": {
            Instructions.addAthlete(input);
            break;
        }
        case "summary-athletes": {
            Print.summaryAthletes(input);
            break;
        }
        case "add-competition": {
            Instructions.addCompetition(input);
            break;
        }
        case "olympic-medal-table": {
            Print.olympicMedalTable(input);
            break;
        }
        case "reset": {
            Instructions.reset(input);
            break;
        }
        case "quit": {
            ArchiveSystem.setEnd(true);
            break;
        }
        default:
            Terminal.printError("Instruction not valid");
        }
    }
}
