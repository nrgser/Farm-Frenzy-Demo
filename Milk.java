public class Milk extends Product{
    public Milk(int x,int y){
        setCount(getCount()+1);
        setPrice(25);
        setX(x);
        setY(y);
        setStorage(1);
        setName("Milk");
    }
}
