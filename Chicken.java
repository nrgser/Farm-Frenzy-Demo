import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Chicken extends DomesticAnimals {
    public void produceEgg() {
        if (isTimeChecked()) {
            Egg egg = new Egg(getX(), getY());
            egg.setCounter(egg.getCounter()+1);
            try {
                getProductHashMap().get(getUser()).add(egg);
            }
            catch (NullPointerException n){
                setProductHashMap(new HashMap<>());
                try{
                    getProductHashMap().get(getUser()).add(egg);
                }catch (NullPointerException e){
                    getProductHashMap().put(getUser(),new ArrayList<>());
                    getProductHashMap().get(getUser()).add(egg);
                }
            }
        }
    }
    public Chicken() {
        Random random = new Random();
        setHealth(100);
        setPrice(100);
        setX(random.nextInt(6) + 1);
        setY(random.nextInt(6) + 1);
        setName("Chicken");
        produceEgg();
        walk();
        if (getHealth() <= 50) {
            eaten(getX(), getY());
        }
    }

    @Override
    public void produced() {
        produceEgg();
    }
}
