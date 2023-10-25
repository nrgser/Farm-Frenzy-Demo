import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ostrich extends DomesticAnimals{

    @Override
    public void produced() {
        produceFeather();
    }

    public void produceFeather() {
        if (isTimeChecked()) {
            Feather feather = new Feather(getX(), getY());
            feather.setCounter(feather.getCounter()+1);
            try{
                getProductHashMap().get(getUser()).add(feather);
            }
            catch (NullPointerException n){
                setProductHashMap(new HashMap<>());
                getProductHashMap().get(getUser()).add(feather);
            }
            getProductHashMap().put(getUser(), getProductHashMap().get(getUser()));
        }
    }

    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public boolean checkWalk(int x, int y) {
        return super.checkWalk(x, y);
    }
    public Ostrich(){
        Random random=new Random();
        setHealth(100);
        setName("Ostrich");
        setPrice(200);
        walk();
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        if (getHealth() <= 50) {
            eaten(getX(), getY());
        }
        checkWalk(getX(),getY());
        produceFeather();
    }
}
