package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository implements Repository {
    private List<Player> players;

    public PlayerRepository() {
        this.players = new LinkedList<>();
    }

    @Override
    public List<Player> getModels() {       //DONE
        return this.players;
    }

    @Override
    public void add(Object model) {
        Player player = (Player) model;
        if (player == null){
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        players.add(player);
    }       //DONE

    @Override
    public boolean remove(Object model) {
        Player player = (Player) model;
        return players.remove(player);
    }       //DONE

    @Override
    public Object findByName(String name) {
        for (Player player:players) {
            if (player.getUsername().equals(name)){
                return player;
            }
        }
        return null;
    }       //DONE
}
