package edu.io;

import java.util.Collections;

import edu.errors.Errors;
import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;

public class Print {

    public static void listSportsVenues(String input) {
        if (Errors.listSportsVenues(input) == false) {
            int place = 0;
            String[] inputParts = input.split(" ");
            Collections.sort(ArchiveSystem.getVenues());
            for (int i = 0; i < ArchiveSystem.getVenues().size(); i++) {
                if (ArchiveSystem.getVenues().get(i).getCountryName().equals(inputParts[1])) {
                    place++;
                    String line = "(" + place + " " + ArchiveSystem.getVenues().get(i).getId() + " "
                            + ArchiveSystem.getVenues().get(i).getCity() + " "
                            + ArchiveSystem.getVenues().get(i).getSeats() + ")";
                    Terminal.printLine(line);
                }
            }
        }
    }

    public static void listOlympicSports(String input) {
        if (Errors.listOlympicSports(input) == false) {
            Collections.sort(ArchiveSystem.getSports());
            for (int i = 0; i < ArchiveSystem.getSports().size(); i++) {
                String line = ArchiveSystem.getSports().get(i).getSportType() + " "
                        + ArchiveSystem.getSports().get(i).getSportDiscipline();
                Terminal.printLine(line);
            }
        }
    }

    public static void listIocCode(String input) {
        if (Errors.listIocCode(input) == false) {
            Collections.sort(ArchiveSystem.getIocCodes());
            for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
                String line = ArchiveSystem.getIocCodes().get(i).getYear() + " "
                        + ArchiveSystem.getIocCodes().get(i).getId() + " "
                        + ArchiveSystem.getIocCodes().get(i).getCode() + " "
                        + ArchiveSystem.getIocCodes().get(i).getCountryName();
                Terminal.printLine(line);
            }
        }
    }

    public static void SummaryAthletes(String input) {
        if (Errors.SummaryAthletes(input) == false) {
            // TODO Auto-generated method stub
        } else {
            // TODO PRINT ERROR
        }
    }

    public static void OlympicMedalTable(String input) {
        if (Errors.OlympicMedalTable(input) == false) {
            // TODO Auto-generated method stub
        } else {
            // TODO PRINT ERROR
        }
    }

}
