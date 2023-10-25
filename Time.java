public class Time {
    private int currentTime;
    public int getTime() {
        return currentTime;
    }
    public void setTime(int time) {
        this.currentTime = time;
    }
    public  Time() {

        setTime(currentTime++);
    }

}
