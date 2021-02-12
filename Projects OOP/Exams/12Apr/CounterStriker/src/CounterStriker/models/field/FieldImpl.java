package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.LinkedList;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    private LinkedList<Player> terrorists;
    private LinkedList<Player> counterTerrorists;

    @Override
    public String start(Collection<Player> inputPlayers) {
        for (Player player : inputPlayers) {
            if (player.getClass().getSimpleName().equals("Terrorist")) {
                terrorists.add( player);
            } else {
                counterTerrorists.add(player);
            }
        }
        for (int terr = 0; terr < terrorists.size(); terr++) {
            int terroristAttack = terrorists.get(terr).getGun().fire();
            for (int counterT = 0; counterT < counterTerrorists.size(); counterT++) {
                if (terrorists.get(terr).isAlive() && counterTerrorists.get(counterT).isAlive()) {
                    counterTerrorists.get(counterT).takeDamage(terroristAttack);
                }
            }
        }
        for (int counterT = 0; counterT < counterTerrorists.size(); counterT++) {
            int counterTerroristAttack = counterTerrorists.get(counterT).getGun().fire();
            for (int terr = 0; terr < terrorists.size(); terr++) {
                if (terrorists.get(terr).isAlive() && counterTerrorists.get(counterT).isAlive()) {
                    terrorists.get(terr).takeDamage(counterTerroristAttack);
                }
            }
        }
        boolean areAllCounterTerroristDead= checkIfAllPlayersAreDead(counterTerrorists);
        if (areAllCounterTerroristDead){
            return TERRORIST_WINS;
        }
        return COUNTER_TERRORIST_WINS;
    }

    private boolean checkIfAllPlayersAreDead(LinkedList<Player> players) {
        boolean alivePlayer = false;
        for (Player play:players) {
            if (play.isAlive()){
                alivePlayer = true;
            }
        }
        return !alivePlayer;
    }
}
