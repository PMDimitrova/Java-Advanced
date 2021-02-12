import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Person> listPersons = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            listPersons.putIfAbsent(name, new Person(name));

            String command = tokens[1];
            switch (command) {
                case "company":
                    //<Name> company <companyName> <department> <salary>"
                    Company company = new Company(tokens[2], tokens[3], tokens[4]);
                    listPersons.get(name).setCompany(company);
                    break;
                case "pokemon":
                    //•	"<Name> pokemon <pokemonName> <pokemonType>"
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    listPersons.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    //•	"<Name> parents <parentName> <parentBirthday>"
                    Parent parent = new Parent(tokens[2], tokens[3]);
                    listPersons.get(name).addParent(parent);
                    break;
                case "children":
                    //•	"<Name> children <childName> <childBirthday>"
                    Child child = new Child(tokens[2], tokens[3]);
                    listPersons.get(name).addChild(child);
                    break;
                case "car":
                    //•	"<Name> car <carModel> <carSpeed>"
                    Car car = new Car(tokens[2], tokens[3]);
                    listPersons.get(name).setCar(car);
                    break;
            }

            input = scan.nextLine();
        }
        String personToPrint = scan.nextLine();

        System.out.println(listPersons.get(personToPrint).toString());

        System.out.println();
    }
}
