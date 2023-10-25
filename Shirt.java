import java.util.Random;

public class Shirt extends Product{
    Random random=new Random();
    public Shirt(){
        setCount(getCount()+1);
        setPrice(100);
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setStorage(4);
        setName("Shirt");
    }
}
