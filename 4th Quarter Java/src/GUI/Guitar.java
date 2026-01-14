package GUI;

public class Guitar {
    private static int nextId = 1;

    private final int id;
    private String brand;
    private String model;
    private double price;

    public Guitar(String brand, String model, double price) {
        this.id = nextId++;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}