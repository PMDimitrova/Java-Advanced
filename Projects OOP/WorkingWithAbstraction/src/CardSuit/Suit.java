package CardSuit;

public enum Suit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);
    private int ordinalValue;

    Suit(int value) {
        this.ordinalValue = value;
    }

    @Override
    public String toString() {
        return "Ordinal value: " + this.ordinalValue + "; Name value: " + this.name();
    }
}
