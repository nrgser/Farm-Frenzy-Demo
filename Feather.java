public class Feather extends Product{
    public Feather(int x, int y){
        setCount(getCount()+1);
        setPrice(20);
        setX(x);
        setY(y);
        setStorage(1);
        setName("Feather");
    }
}