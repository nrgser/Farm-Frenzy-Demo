public class Well {
    private int capacity;
    private int startTime;
    private boolean checkTime;

    public boolean isCheckTime() { return checkTime; }
    public void setCheckTime(boolean checkTime) { this.checkTime = checkTime; }
    public int getStartTime() { return startTime; }
    public void setTime(int time) {
        this.startTime = time;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
