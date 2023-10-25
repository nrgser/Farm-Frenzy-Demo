import java.util.Random;

public class Cloth extends Product{
    Random random=new Random();
    public Cloth(){
        setCount(getCount()+1);
        setPrice(50);
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setStorage(2);
        setName("Cloth");
    }
}