package Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    private static final double SALMON_GRAMS = 22;
    public Salmon(String name, BigDecimal price, double grams) {
        super(name, price, SALMON_GRAMS);
    }

    @Override
    public double getGrams() {
        return this.SALMON_GRAMS;
    }
}
