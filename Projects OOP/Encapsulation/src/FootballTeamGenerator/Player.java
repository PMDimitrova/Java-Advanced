package FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkStatValue(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkStatValue(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkStatValue(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkStatValue(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkStatValue(shooting, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel() {
        return ((this.endurance + this.sprint + this.dribble + this.passing + this.shooting) * 1.0) / 5;
    }

    private void checkStatValue(int value, String statType) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(statType + " should be between 0 and 100.");
        }
    }
}
