package guild;

import java.util.*;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public String report() {
        StringBuilder output = new StringBuilder();

        output.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        for (Player play : this.roster.values()) {
            output.append(play.toString());
        }

        return output.toString();
    }

    public int count() {
        return this.roster.size();
    }

    public Player[] kickPlayersByClass(String clazz) {
        ArrayList<Player> output = new ArrayList<>();

        for (Player play : roster.values()) {
            if (play.getClazz().equals(clazz)) {
                output.add(play);
            }
        }

        for (Player player : output) {
            this.roster.remove(player.getName());
        }

        Player[] outputAsList = new Player[output.size()];
        for (int i = 0; i < outputAsList.length; i++) {
            outputAsList[i] = output.get(i);
        }

        return outputAsList;
    }

    public void demotePlayer(String name) {
        if (!this.roster.get(name).getRank().equals("Trial")) {
            this.roster.get(name).setRank("Trial");
        }
    }

    public void promotePlayer(String name) {
        if (!this.roster.get(name).getRank().equals("Member")) {
            this.roster.get(name).setRank("Member");
        }
    }

    public boolean removePlayer(String name) {
        if (this.roster.containsKey(name)) {
            this.roster.remove(name);
            return true;
        }
        return false;
    }

    public void addPlayer(Player player) {
        if (this.roster.size()<20){
            this.roster.put(player.getName(), player);
        }
    }
}
