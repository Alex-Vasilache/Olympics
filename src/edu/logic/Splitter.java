package edu.logic;

import edu.io.Print;
import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;

public class Splitter {

	public static void split(String input) {

		String[] parts = input.split(" ", 2);
		switch (parts[0]) {
		case "add-admin": {
			Instructions.addAdmin(parts[1]);
			break;
		}
		case "login-admin": {
			Instructions.loginAdmin(parts[1]);
			break;
		}
		case "logout-admin": {
			Instructions.logoutAdmin();
			break;
		}
		case "add-sports-venue": {
			Instructions.addSportsVenue(parts[1]);
			break;
		}
		case "list-sports-venues": {
			Print.listSportsVenues(parts[1]);
			break;
		}
		case "add-olympic-sport": {
			Instructions.addOlympicSport(parts[1]);
			break;
		}
		case "list-olympic-sports": {
			Print.listOlympicSports(parts[1]);
			break;
		}
		case "add-ioc-code": {
			Instructions.addIocCode(parts[1]);
			break;
		}
		case "list-ioc-codes": {
			Print.listIocCode(parts[1]);
			break;
		}
		case "add-athlete": {
			Instructions.addAthlete(parts[1]);
			break;
		}
		case "summary-athletes": {
			Print.SummaryAthletes(parts[1]);
			break;
		}
		case "add-competition": {
			Instructions.addCompetition(parts[1]);
			break;
		}
		case "olympic-medal-table": {
			Print.OlympicMedalTable(parts[1]);
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
