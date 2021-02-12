package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputData = scan.nextLine().split(";");
        Map<String, Team> teams = new LinkedHashMap<>();

        while (!inputData[0].equals("END")) {
            String command = inputData[0];
            switch (command) {
                case "Team":
                    Team team = new Team(inputData[1]);
                    teams.put(team.getName(), team);
                    break;
                case "Add":
                    String teamName = inputData[1];
                    try{
                    Player player = createPlayer(inputData);
                    if (teams.containsKey(teamName)) {
                        teams.get(teamName).addPlayer(player);
                    } else {
                        System.out.println("Team " + teamName + " does not exist.");
                    }}
                    catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Remove":
                    Team teamToRemoveFrom = teams.get(inputData[1]);
                    teamToRemoveFrom.removePlayer(inputData[2]);
                    break;
                case "Rating":
                    if (teams.containsKey(inputData[1])) {
                        int rating = (int)Math.round(teams.get(inputData[1]).getRating());
                        System.out.printf("%s - %d%n", inputData[1], rating );
                    } else {
                        System.out.println("Team " + inputData[1] + " does not exist.");
                    }
                    break;
            }

            inputData = scan.nextLine().split(";");
        }


    }

    private static Player createPlayer(String[] inputData) {
        Player player = new Player(inputData[2],
                Integer.parseInt(inputData[3]),
                Integer.parseInt(inputData[4]),
                Integer.parseInt(inputData[5]),
                Integer.parseInt(inputData[6]),
                Integer.parseInt(inputData[7]));
        return player;
    }
}
