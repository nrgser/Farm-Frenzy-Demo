import java.util.Random;

public class Bread extends Product{
    Random random=new Random();
    public Bread(){
        setCount(getCount()+1);
        setPrice(80);
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setStorage(4);
        setName("Bread");
    }
}
