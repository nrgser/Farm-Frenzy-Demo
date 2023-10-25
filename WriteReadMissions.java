import com.google.gson.Gson;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WriteReadMissions {
    public void data() {
        Map<String, Integer> task1 = new HashMap<>();
        task1.put("flour", 2);
        task1.put("bread", 2);
        task1.put("chicken", 4);
        Map<String,Integer> wildAnimalsTimeHashMap1 = new HashMap<>();
        wildAnimalsTimeHashMap1.put("bear",2);
        wildAnimalsTimeHashMap1.put("bear",4);
        wildAnimalsTimeHashMap1.put("bear",8);


        Missions missions1 = new Missions(1, 10, 200,task1,wildAnimalsTimeHashMap1,300 );
        Map<String, Integer> task2 = new HashMap<>();
        task2.put("feather", 2);
        task2.put("cloth", 2);
        task2.put("ostrich", 2);
        Map<String,Integer> wildAnimalsTimeHashMap2 = new HashMap<>();
        wildAnimalsTimeHashMap2.put("lion",1);
        wildAnimalsTimeHashMap2.put("lion",4);
        wildAnimalsTimeHashMap2.put("lion",7);


        Missions missions2 = new Missions(2, 8, 500,task2,wildAnimalsTimeHashMap2,400 );
        Map<String, Integer> task3 = new HashMap<>();
        task2.put("milk", 4);
        task2.put("iceCream", 2);
        task2.put("buffalo", 2);
        Map<String,Integer> wildAnimalsTimeHashMap3 = new HashMap<>();
        wildAnimalsTimeHashMap2.put("tiger",1);
        wildAnimalsTimeHashMap2.put("tiger",5);


        Missions missions3 = new Missions(3, 6, 700,task3,wildAnimalsTimeHashMap3,600 );
        ArrayList<Missions> missions=new ArrayList<>();
        missions.add(missions1);
        missions.add(missions2);
        missions.add(missions3);
        write(missions);

    }
    public List<Missions> read(List<Missions> list) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("mission.json"));
            List<Missions> order = Arrays.asList(gson.fromJson(reader, Missions[].class));
            list=order;
            reader.close();
            return order;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public void write( ArrayList<Missions> missions ) {
        try {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("mission.json"));
            gson.toJson(missions, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}