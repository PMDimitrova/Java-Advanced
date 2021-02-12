public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon (String name, String element, String health){
        this.name = name;
        this.element = element;
        this.health = Integer.parseInt(health);
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(){
        this.health -=10;
    }
}
