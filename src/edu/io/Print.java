package edu.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.errors.Errors;
import edu.kit.informatik.Terminal;
import edu.objects.ArchiveSystem;
import edu.objects.CompetingCountry;

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
            String[] inputParts = input.split(" ");
            Collections.sort(ArchiveSystem.getAthletes());
            for (int i = 0; i < ArchiveSystem.getAthletes().size(); i++) {
                for (int j = 0; j < ArchiveSystem.getAthletes().get(i).getSports().size(); j++) {
                    if (ArchiveSystem.getAthletes().get(i).getSports().get(j).getSportDiscipline()
                            .equals(inputParts[1])) {
                        String line = ArchiveSystem.getAthletes().get(i).getId() + " "
                                + ArchiveSystem.getAthletes().get(i).getFirstName() + " "
                                + ArchiveSystem.getAthletes().get(i).getLastName() + " "
                                + ArchiveSystem.getAthletes().get(i).getMedals();
                        Terminal.printLine(line);
                    }
                }
            }
        }
    }

    public static void OlympicMedalTable(String input) {
        if (Errors.OlympicMedalTable(input) == false) {
            List<CompetingCountry> competingCountries = new ArrayList<CompetingCountry>();
            for (int i = 0; i < ArchiveSystem.getIocCodes().size(); i++) {
                CompetingCountry c = new CompetingCountry(ArchiveSystem.getIocCodes().get(i));
                competingCountries.add(c);
            }
            for (int i = 0; i < ArchiveSystem.getCompetitions().size(); i++) {
                for (int j = 0; j < competingCountries.size(); j++) {
                    if (ArchiveSystem.getCompetitions().get(i).getAthlete().getIocCode()
                            .equals(competingCountries.get(j).getIocCode())) {
                        competingCountries.get(j).setGold(ArchiveSystem.getCompetitions().get(i).getGold());
                        competingCountries.get(j)
                                .setSilver(ArchiveSystem.getCompetitions().get(i).getSilver());
                        competingCountries.get(j)
                                .setBronze(ArchiveSystem.getCompetitions().get(i).getBronze());
                    }
                }
            }
            Collections.sort(competingCountries);
            for (int i = 0; i < competingCountries.size(); i++) {
                int place = i + 1;
                String line = "(" + place + "," + competingCountries.get(i).getIocCode().getId() + ","
                        + competingCountries.get(i).getIocCode().getCode() + ","
                        + competingCountries.get(i).getIocCode().getCountryName() + ","
                        + competingCountries.get(i).getGold() + "," + competingCountries.get(i).getSilver()
                        + "," + competingCountries.get(i).getBronze() + ","
                        + competingCountries.get(i).getMedals() + ")";
                Terminal.printLine(line);
            }
        }
    }
}
