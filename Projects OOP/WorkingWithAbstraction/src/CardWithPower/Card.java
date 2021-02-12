package CardWithPower;

public class Card {
    private CardRank type;
    private Suit suit;

    Card(CardRank name, Suit suit) {
        this.type = name;
        this.suit = suit;

    }

    private int getPower() {
        return type.getValue() + suit.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.type, this.suit, getPower());
    }
}
