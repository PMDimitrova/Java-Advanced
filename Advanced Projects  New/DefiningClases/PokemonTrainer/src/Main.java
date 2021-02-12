import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        Map<String, Trainer> listOfTrainers = new LinkedHashMap<>();
        //<name, actual obj trainer>

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            //<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
            String nameOfTrainer = tokens[0];
            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], tokens[3]);
            Trainer trainer = new Trainer(tokens[0], 0, new LinkedList<>());

            listOfTrainers.putIfAbsent(nameOfTrainer, trainer);
            listOfTrainers.get(nameOfTrainer).getPokemons().add(pokemon);

            line = scan.nextLine();
        }
        line = scan.nextLine();
        while (!line.equals("End")) {
            String element = line;
            for (Trainer tr : listOfTrainers.values()) {
                if (tr.checkIfHasThisElementPokemon(element)) {
                    tr.increaseBadges();
                } else {
                    tr.decreasePokemonHealth();
                }
            }
            line = scan.nextLine();
        }
        listOfTrainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getBadges(), b1.getValue().getBadges()))
                .forEach(t ->{
                    System.out.println(t.getValue().toString());
                });
    }
}
