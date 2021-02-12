package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository gunRepo;
    private PlayerRepository playerRepo;
    private Field field;

    public ControllerImpl() {
        this.gunRepo = new GunRepository();
        this.playerRepo = new PlayerRepository();
        this.field = new FieldImpl();
    }


    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type) {
            case "Pistol":
              gun = new Pistol (name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        gunRepo.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }       //DONE

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player;
        Gun gun;

        try{
            gun = (Gun)gunRepo.findByName(gunName);
        }catch (NullPointerException ex ){
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        playerRepo.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }//DONE

    @Override
    public String startGame() {

        return field.start(playerRepo.getModels());
    }

    @Override
    public String report() {
        return null;
    }
}

//    Returns information about each player separated with a new line.
//    Order them by type alphabetically,
//    then by health descending,
//    then by username alphabetically. You can use the overridden .toString() Player method.

//        "{player type}: {player username}
//        --Health: {player health}
//        --Armor: {player armor}
//        --Gun: {player gun name}"

//CounterTerrorist: John
//        --Health: 0
//        --Armor: 0
//        --Gun: Kolibri
//        CounterTerrorist: Peter
//        --Health: 0
//        --Armor: 0
//        --Gun: Makarov
//        Terrorist: Kris
//        --Health: 50
//        --Armor: 46
//        --Gun: Buffalo
//        Terrorist: Shopoff
//        --Health: 50
//        --Armor: 45
//        --Gun: Express

