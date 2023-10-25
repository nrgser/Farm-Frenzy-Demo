public class Egg extends Product{
    public Egg(int x,int y){
        setCount(getCount()+1);
        setPrice(15);
        setX(x);
        setY(y);
        setStorage(1);
        setName("Egg");
    }
}
