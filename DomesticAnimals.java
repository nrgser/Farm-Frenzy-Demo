import java.util.*;

public class DomesticAnimals extends Animals{
    private int startTime;
    ArrayList<Double> desGrass=new ArrayList<>();
    private boolean timeChecked;
    private Map<UserInformation,ArrayList<Grass>> grassHashMap;
    private int counter;

    public int getCounter() { return counter; }

    public void setCounter(int counter) { this.counter = counter; }
    public void produced(){}

    public boolean isTimeChecked() { return timeChecked; }

    public void setTimeChecked(boolean timeChecked) { this.timeChecked = timeChecked; }

    public void setGrassHashMap(Map<UserInformation, ArrayList<Grass>> grassHashMap) {
        this.grassHashMap = grassHashMap;
    }

    public int getTime() { return startTime; }
    public void setTime(int time){
    this.startTime=time;
}
    public void eaten(int x,int y){
        if(grassHashMap==null) grassHashMap=new HashMap<>();
        if(grassHashMap.get(getUser())==null) grassHashMap.put(getUser(),new ArrayList<>());
        for(int i=0;i<grassHashMap.get(getUser()).size();i++){
            int x1=grassHashMap.get(getUser()).get(i).getX();
            int y1=grassHashMap.get(getUser()).get(i).getY();
            double des=Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
            desGrass.add(des);
        } Collections.sort(desGrass);
        /*for(int t=1;t<6;t++){
            health=health/10;
        }*/
        for(int i=0;i<grassHashMap.get(getUser()).size();i++){
            int x1=grassHashMap.get(getUser()).get(i).getX();
            int y1=grassHashMap.get(getUser()).get(i).getY();
            double des=Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
            if (desGrass.get(0) == des) {
                grassHashMap.get(getUser()).remove(i);
                grassHashMap.put(getUser(),grassHashMap.get(getUser()));
                setHealth(100);
            }
        }
    }

}
