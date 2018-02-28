package edu.logic;

import edu.io.Print;
import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;

public class Splitter {

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
            Print.SummaryAthletes(input);
            break;
        }
        case "add-competition": {
            Instructions.addCompetition(input);
            break;
        }
        case "olympic-medal-table": {
            Print.OlympicMedalTable(input);
            break;
        }
        case "reset": {
            Instructions.reset();
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
