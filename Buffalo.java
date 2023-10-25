import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Buffalo extends DomesticAnimals{

    @Override
    public void produced() {
        produceMilk();
    }

    public Buffalo(){
        Random random=new Random();
        setHealth(100);
        setName("Buffalo");
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setPrice(400);
        produceMilk();
        if (getHealth() <= 50) {
            eaten(getX(), getY());
        }
        walk();
    }
    public void produceMilk() {/*
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (isTimeChecked()) {
            Milk milk = new Milk(getX(), getY());
            milk.setCounter(milk.getCounter()+1);
            try {
                getProductHashMap().get(getUser()).add(milk);
            }
            catch (NullPointerException n){
                setProductHashMap(new HashMap<>());
                try{
                    getProductHashMap().get(getUser()).add(milk);
                }
                catch (NullPointerException e){
                    getProductHashMap().put(getUser(),new ArrayList<>());
                    getProductHashMap().get(getUser()).add(milk);
                }
            }
        }
    }
}
