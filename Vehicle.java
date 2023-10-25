import java.util.ArrayList;

public class Vehicle {
    private int capacity;
    private int speed;
    private int level;
    private int startTime;
    private boolean checkTime;
    private ArrayList<WildAnimals> wildAnimals;
    private ArrayList<Product> products;

    public boolean isCheckTime() { return checkTime; }

    public void setCheckTime(boolean checkTime) { this.checkTime = checkTime; }

    public int getStartTime() { return startTime; }

    public void setStartTime(int time) {
        this.startTime = time;
    }

    public ArrayList<WildAnimals> getWildAnimals() {
        return wildAnimals;
    }

    public void setWildAnimals(ArrayList<WildAnimals> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public Vehicle(){
        this.capacity=0;
        this.level=1;
        this.speed=10;
    }
}
