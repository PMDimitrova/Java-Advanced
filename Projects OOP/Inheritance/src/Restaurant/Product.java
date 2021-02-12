package Restaurant;

import java.math.BigDecimal;
import java.nio.file.Path;

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
