import java.util.LinkedList;
import java.util.List;

public class Person {
    //1company, 1car; multiple parents, children, pokemons
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents = new LinkedList<>();
    private List<Child> children = new LinkedList<>();
    private List<Pokemon> pokemons = new LinkedList<>();

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String companyPrint = this.company != null ? this.company.toString() : "Company: ";
        String carPrint = this.car != null ? this.car.toString() : "Car: ";
        String pokemonsPrint = pokemons.size() != 0 ? pokemonsList() : "Pokemon: "; //smthg with printing pokemons is not correct
        String parentsPrint = parents.size() != 0 ? parentsList() : "Parents: ";
        String childrenPrint = children.size() != 0 ? childrenList() : "Children: ";
        String output = this.name + System.lineSeparator()
                + companyPrint + System.lineSeparator()
                + carPrint + System.lineSeparator()
                + pokemonsPrint + System.lineSeparator()
                + parentsPrint + System.lineSeparator()
                + childrenPrint;

        return output;
    }

    private String childrenList() {
        String output = "Children:";
        for (Child chi: children) {
            output = output + System.lineSeparator() + chi.toString();
        }
        return output;
    }

    private String parentsList() {
        String output = "Parents:";
        for (Parent par : parents) {
            output = output + System.lineSeparator() + par.toString();
        }
        return output;
    }

    private String pokemonsList() {
        String output = "Pokemon:";
        for (Pokemon pok : pokemons) {
            output = output + System.lineSeparator() + pok.toString();
        }
        return output;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
