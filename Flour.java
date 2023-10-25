import java.util.Random;

public class Flour extends Product{
    Random random=new Random();
    public Flour(){
        setCount(getCount()+1);
        setPrice(40);
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setStorage(2);
        setName("Flour");
    }
}
