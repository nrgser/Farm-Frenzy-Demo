import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cat extends Animals{
    private Map<UserInformation,ArrayList<Product>> productHashmap;
    private Map<UserInformation,WereHouse> wereHouseHashMap;
    private int startTime;

    public int getStartTime() { return startTime; }

    public void setTime(int time) {
        this.startTime = time;
    }

    public void setWereHouseHashMap(Map<UserInformation, WereHouse> wereHouseHashMap) {
        this.wereHouseHashMap = wereHouseHashMap;
    }

    public void setProductHashmap(Map<UserInformation, ArrayList<Product>> productHashmap) {
        this.productHashmap = productHashmap;
    }


    public void walk() {
        super.walk();
    }
    public void collectProduct(){
        if(productHashmap!=null) {
            if (productHashmap.get(getUser()) != null) {
                for (int i = 0; i < productHashmap.get(getUser()).size(); i++) {
                    if (productHashmap.get(getUser()).get(i).getX() == getX() && productHashmap.get(getUser()).get(i).getY() == getY()) {
                        try {
                            wereHouseHashMap.get(getUser()).addProducts(productHashmap.get(getUser()).get(i));
                        } catch (NullPointerException n) {
                            wereHouseHashMap = new HashMap<>();
                            try{
                                wereHouseHashMap.get(getUser()).addProducts(productHashmap.get(getUser()).get(i));
                            }
                            catch (NullPointerException e){
                                wereHouseHashMap.put(getUser(),new WereHouse());
                                wereHouseHashMap.get(getUser()).addProducts(productHashmap.get(getUser()).get(i));
                            }
                        }
                        productHashmap.remove(getUser(), productHashmap.get(getUser()).get(i));
                    }
                }
            }
        }else {
            productHashmap=new HashMap<>();
            if (productHashmap.get(getUser()) != null) {
                for (int i = 0; i < productHashmap.get(getUser()).size(); i++) {
                    if (productHashmap.get(getUser()).get(i).getX() == getX() && productHashmap.get(getUser()).get(i).getY() == getY()) {
                        try {
                            wereHouseHashMap.get(getUser()).addProducts(productHashmap.get(getUser()).get(i));
                        } catch (NullPointerException n) {
                            wereHouseHashMap = new HashMap<>();
                            try{
                                wereHouseHashMap.get(getUser()).addProducts(productHashmap.get(getUser()).get(i));
                            }
                            catch (NullPointerException e){
                                wereHouseHashMap.put(getUser(),new WereHouse());
                                wereHouseHashMap.get(getUser()).addProducts(productHashmap.get(getUser()).get(i));
                            }
                        }
                        productHashmap.remove(getUser(), productHashmap.get(getUser()).get(i));
                    }
                }
            }
        }
    }
    public Cat(){
        Random random=new Random();
        setY(random.nextInt(6)+1);
        setX(random.nextInt(6)+1);
        setHealth(100);
        setName("Cat");
        setPrice(150);
        walk();
        collectProduct();
    }

}
