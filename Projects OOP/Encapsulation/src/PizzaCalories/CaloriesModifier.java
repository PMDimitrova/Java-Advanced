package PizzaCalories;

public class CaloriesModifier {
    private static double white = 1.5;
    private static double wholegrain = 1.0;
    private static double crispy = 0.9;
    private static double chewy = 1.1;
    private static double homemade = 1.0;
    private static double meat = 1.2;
    private static double veggies = 0.8;
    private static double cheese = 1.1;
    private static double sauce = 0.9;

    public static double getValueFor(String type) {
        double output = 0;
        switch (type) {
            case "White":
                output = white;
                break;
            case "Wholegrain":
                output = wholegrain;
                break;
            case "Crispy":
                output = crispy;
                break;
            case "Chewy":
                output = chewy;
                break;
            case "Homemade":
                output = homemade;
                break;
            case "Meat":
                output = meat;
                break;
            case "Veggies":
                output = veggies;
                break;
            case "Cheese":
                output = cheese;
                break;
            case "Sauce":
                output = sauce;
                break;
        }

        return output;
    }

}
