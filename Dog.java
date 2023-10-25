import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dog extends Animals {
    private Map<UserInformation,WereHouse> wereHouseHashMap;
    private Map<UserInformation, ArrayList<WildAnimals>> wildAnimalsHashMap;
    private Map<UserInformation,Dog> dogHashMap;
    private int startTime;
    public int getStartTime() { return startTime; }
    public void setTime(int time) {
        this.startTime = time;
    }

    public void setDogHashMap(Map<UserInformation, Dog> dogHashMap) {
        this.dogHashMap = dogHashMap;
    }

    public void setWereHouseHashMap(Map<UserInformation, WereHouse> wereHouseHashMap) {
        this.wereHouseHashMap = wereHouseHashMap;
    }

    public void setWildAnimalsHashMap(Map<UserInformation, ArrayList<WildAnimals>> wildAnimalsHashMap) {
        this.wildAnimalsHashMap = wildAnimalsHashMap;
    }


    public void walk() {
        super.walk();
    }
    public void killWildAnimals(){
        if(wildAnimalsHashMap!=null) {
            if (wildAnimalsHashMap.get(getUser()) != null) {
                for (int i = 0; i < wildAnimalsHashMap.get(getUser()).size(); i++) {
                    if (wildAnimalsHashMap.get(getUser()).get(i).getX() == getX() && wildAnimalsHashMap.get(getUser()).get(i).getY() == getY()) {
                        try {
                            wereHouseHashMap.get(getUser()).addWildAnimals(wildAnimalsHashMap.get(getUser()).get(i));
                        } catch (NullPointerException n) {
                            wereHouseHashMap = new HashMap<>();
                            try{
                                wereHouseHashMap.get(getUser()).addWildAnimals(wildAnimalsHashMap.get(getUser()).get(i));
                            }catch (NullPointerException e){
                                wereHouseHashMap.put(getUser(),new WereHouse());
                                wereHouseHashMap.get(getUser()).addWildAnimals(wildAnimalsHashMap.get(getUser()).get(i));
                            }
                        }
                        wildAnimalsHashMap.remove(getUser(), wildAnimalsHashMap.get(getUser()).get(i));
                        dogHashMap.remove(getUser());
                    }
                }
            }
        }else {
            wildAnimalsHashMap=new HashMap<>();
            if (wildAnimalsHashMap.get(getUser()) != null) {
                for (int i = 0; i < wildAnimalsHashMap.get(getUser()).size(); i++) {
                    if (wildAnimalsHashMap.get(getUser()).get(i).getX() == getX() && wildAnimalsHashMap.get(getUser()).get(i).getY() == getY()) {
                        try {
                            wereHouseHashMap.get(getUser()).addWildAnimals(wildAnimalsHashMap.get(getUser()).get(i));
                        } catch (NullPointerException n) {
                            wereHouseHashMap = new HashMap<>();
                            try{
                                wereHouseHashMap.get(getUser()).addWildAnimals(wildAnimalsHashMap.get(getUser()).get(i));
                            }catch (NullPointerException e){
                                wereHouseHashMap.put(getUser(),new WereHouse());
                                wereHouseHashMap.get(getUser()).addWildAnimals(wildAnimalsHashMap.get(getUser()).get(i));
                            }
                        }
                        wildAnimalsHashMap.remove(getUser(), wildAnimalsHashMap.get(getUser()).get(i));
                        dogHashMap.remove(getUser());
                    }
                }
            }
        }
    }
    public Dog(){
        Random random=new Random();
        setY(random.nextInt(6)+1);
        setX(random.nextInt(6)+1);
        setHealth(100);
        setName("Dog");
        setPrice(100);
        walk();
        killWildAnimals();
    }
}
