public class Grass {
    private int x;
    private int y;
    private int startTime;

    public int getStartTime() { return startTime; }

    public void setStartTime(int startTime) { this.startTime = startTime; }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Grass (int x, int y){
        this.x=x;
        this.y=y;
    }
}

