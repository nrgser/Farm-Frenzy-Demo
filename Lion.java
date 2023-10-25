import java.util.Random;

public class Lion extends WildAnimals{
    private int startTime;

    public int getStartTime() { return startTime; }

    public void setStartTime(int startTime) { this.startTime = startTime; }

    public void walk() {
        super.walk();
    }
    @Override
    public boolean checkWalk(int x, int y) {
        return super.checkWalk(x, y);
    }
    Random random=new Random();
    public Lion(){
        setX(random.nextInt(6)+1);
        setY(random.nextInt(6)+1);
        setInCage(0);
        setPrice(300);
        setStorage(15);
        setName("Lion");
        setHealth(100);
        walk();
        checkWalk(getX(),getY());
    }
}
