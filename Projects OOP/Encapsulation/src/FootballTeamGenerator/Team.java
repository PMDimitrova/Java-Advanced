package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        Player playerToRemove = null;
        for (Player pl : players) {
            if (pl.getName().equals(name)) {
                playerToRemove = pl;
            }
        }
        if (playerToRemove == null) {
            System.out.println("Player " + name + " is not in " + this.name + " team.");
        } else {
            players.remove(playerToRemove);
        }
    }

    public double getRating() {
        double output = players.stream().mapToDouble(Player::overallSkillLevel).sum();
        output = output / players.size();
        return output;
    }
}
