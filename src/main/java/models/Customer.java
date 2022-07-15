package models;

public class Customer {
    private int id;
    private String name;
    private double price;
    private String img;
    private Category category;
    private boolean status;


    public Customer() {
    }

    public Customer(int id, String name, double price, String img, Category category, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
        this.status = status;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
