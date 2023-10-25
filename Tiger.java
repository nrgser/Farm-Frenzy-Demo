import java.util.Random;

public class Tiger extends WildAnimals{
    private int startTime;

    public int getStartTime() { return startTime; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    @Override
    public boolean checkWalk(int x, int y) {
        return super.checkWalk(x, y);
    }
    @Override
    public void walk() {
        super.walk();
    }
    Random random=new Random();
    public Tiger(){
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setInCage(0);
        setPrice(500);
        setStorage(15);
        setName("Tiger");
        setHealth(100);
        checkWalk(getX(),getY());
        walk();
    }
}
