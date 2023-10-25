import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Missions {
    private boolean checkComplete;
    private int level;
    private int maxTime;
    private Map<String,Integer> task;
    private Map<String, Integer> wildAnimalsTimeHashMap;
    private int coins;
    private int gift;

    public int getCoins() { return coins; }

    public Map<String,Integer> getTask() { return task; }

    public boolean isCheckComplete() { return checkComplete; }

    public Map<String, Integer> getWildAnimalsTimeHashMap() { return wildAnimalsTimeHashMap; }

    public int getGift() { return gift; }

    public int getLevel() { return level; }

    public int getMaxTime() { return maxTime; }

    public void setCheckComplete(boolean checkComplete) { this.checkComplete = checkComplete; }

    public void setCoins(int coins) { this.coins = coins; }

    public void setGift(int gift) { this.gift = gift; }

    public void setLevel(int level) { this.level = level; }

    public void setMaxTime(int maxTime) { this.maxTime = maxTime; }

    public void setTask(Map<String, Integer> task) { this.task = task; }

    public void setWildAnimalsTimeHashMap(Map<String, Integer> wildAnimalsTimeHashMap) { this.wildAnimalsTimeHashMap = wildAnimalsTimeHashMap; }
//wilde animal time
    public Missions(int level,int maxTime,int coins,Map<String,Integer> task,Map<String,Integer> wildAnimalsTimeHashMap,int gift){
        this.coins=coins;
        this.gift=gift;
        this.level=level;
        this.maxTime=maxTime;
        this.wildAnimalsTimeHashMap=wildAnimalsTimeHashMap;
        this.task=task;
    }



}
