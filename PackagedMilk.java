import java.util.Random;

public class PackagedMilk extends Product{
    Random random=new Random();
    public PackagedMilk(){
        setCount(getCount()+1);
        setPrice(60);
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setStorage(2);
        setName("PackagedMilk");
    }
}
