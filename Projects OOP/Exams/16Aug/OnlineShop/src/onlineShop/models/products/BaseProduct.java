package onlineShop.models.products;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.PRODUCT_TO_STRING;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    public BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        this.setId(id);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(INVALID_PRODUCT_ID);
        }
        this.id = id;
    }        //DONE

    private void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }       //DONE

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_MODEL);
        }
        this.model = model;
    }       //DONE

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }       //DONE

    private void setOverallPerformance(double overallPerformance) {
        if (overallPerformance <= 0) {
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }       //DONE

    @Override
    public int getId() {
        return this.id;
    }       //DONE

    @Override
    public String getManufacturer() {        //DONE
        return this.manufacturer;
    }       //DONE

    @Override
    public String getModel() {        //DONE
        return this.model;
    }       //DONE

    @Override
    public double getPrice() {        //DONE
        return this.price;
    }       //DONE

    @Override
    public double getOverallPerformance() {       //DONE
        return this.overallPerformance;
    }       //DONE

    @Override
    public String toString() {
        return String.format(PRODUCT_TO_STRING,
                getOverallPerformance(),
                getPrice(),
                this.getClass().getSimpleName(),
                getManufacturer(),
                getModel(),
                getId());
    }
}
