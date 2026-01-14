package GUI;

public class Guitarbrands {

    public static final String FENDER = "FENDER";
    public static final String GIBSON = "GIBSON";
    public static final String IBANEZ = "IBANEZ";

    public static Guitar createGuitar(String brand, String model, double price) {
        switch (brand) {
            case FENDER:
            case GIBSON:
            case IBANEZ:
                return new Guitar(brand, model, price);
            default:
                return null;
        }
    }
}

