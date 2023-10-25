import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Animals {
    private int x;
    private int y;
    private int[] xAx = {0,1,0,-1};
    private int[] yAx = {1,0,-1,0};
    private int storage;
    private UserInformation user;
    private int health;
    private int price;
    private String name;
    private Map<UserInformation, ArrayList<Product>> productHashMap;
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }

    public Map<UserInformation, ArrayList<Product>> getProductHashMap() {
        return productHashMap;
    }

    public void setProductHashMap(Map<UserInformation, ArrayList<Product>> productHashMap) { this.productHashMap = productHashMap; }

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
    public int[] getxAx() {
        return xAx;
    }
    public int[] getyAx() {
        return yAx;
    }
    public boolean checkWalk(int x, int y){
        if(x>=0&&x<6&&y>=0&&y<6){
            return true;
        }else return false;
    }
    public void walk(){
        Random random=new Random();
        int rand=((random.nextInt() %4 )+4)%4;
        int counter = 0;
        for (int i = rand;counter<4 ; i++) {
            if (checkWalk(getX()+getxAx()[i%4],getY()+getyAx()[i%4])){
                setX(getX()+getxAx()[i%4]);
                setY(getY()+getyAx()[i%4]);
            }
            counter++;
        }

    }
}
