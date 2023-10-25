import java.util.ArrayList;

public class Product {
    private int x;
    private int y;
    private int count;
    private int price;
    private int storage;
    private String  name;
    private int startTime;
    private int counter;

    public int getCounter() { return counter; }

    public void setCounter(int counter) { this.counter = counter; }

    public int getStartTime() { return startTime; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    private ArrayList<WildAnimals> wildAnimals;

    public ArrayList<WildAnimals> getWildAnimals() {
        return wildAnimals;
    }

    public void setWildAnimals(ArrayList<WildAnimals> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}