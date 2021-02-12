import java.util.List;

public class Trainer {
    private String name;
    private int numOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int numOfBadges, List<Pokemon> pokemons){
        this.name = name;
        this.numOfBadges = numOfBadges;     // starts with 0
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean checkIfHasThisElementPokemon(String element) {
        for (Pokemon pokemon:pokemons) {
            if (pokemon.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void increaseBadges(){
        this.numOfBadges += 1;
    }

    public void decreasePokemonHealth() {
        for (Pokemon poke:pokemons) {
            poke.decreaseHealth();
            if (poke.getHealth()<=0){
                pokemons.remove(poke);
            }
        }
    }

    public int getBadges() {
        return numOfBadges;
    }
    //<TrainerName> <Badges> <NumberOfPokemon>


    @Override
    public String toString() {
        String name = this.name;
        int badgesCount = this.numOfBadges;
        int countPokemonst = this.pokemons.size();
        return name + " " + badgesCount + " " + countPokemonst;
    }
}
