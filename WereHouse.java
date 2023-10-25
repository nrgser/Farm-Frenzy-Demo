import java.util.ArrayList;

public class WereHouse {
    private int storage;
    private final int MAX_STORAGE=30;
    private ArrayList<WildAnimals> wildAnimals;
    private ArrayList<Product> products;

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getMAX_STORAGE() {
        return MAX_STORAGE;
    }

    public ArrayList<WildAnimals> getWildAnimals() {
        return wildAnimals;
    }

    public void addWildAnimals(WildAnimals w) {
        wildAnimals.add(w);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(Product p) {
        products.add(p);
    }

    public void setWildAnimals(ArrayList<WildAnimals> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
