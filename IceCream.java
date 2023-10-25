import java.util.Random;

public class IceCream extends Product{
    Random random=new Random();
    public IceCream(){
        setCount(getCount()+1);
        setPrice(120);
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setStorage(4);
        setName("IceCream");
    }
}
