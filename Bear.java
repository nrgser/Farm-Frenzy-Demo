import java.util.Random;

public class Bear extends WildAnimals{
    private int startTime;

    public int getStartTime() { return startTime; }
    public void setTime(int time) {
        this.startTime = time;
    }
    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public boolean checkWalk(int x, int y) {
        return super.checkWalk(x, y);
    }
    Random random=new Random();
    public Bear(){
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setInCage(0);
        setPrice(400);
        setStorage(15);
        setName("Bear");
        checkWalk(getX(),getY());
        walk();
    }
}
