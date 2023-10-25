import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Save {
    private Map<UserInformation,ArrayList<DomesticAnimals>> domesticAnimalsHashMap;
    private Map<UserInformation,ArrayList<Factory>> factoryHashMap;
    private Map<UserInformation,ArrayList<Grass>> grassHashMap;
    private Map<UserInformation,ArrayList<Product>> productHashMap;
    private Map<UserInformation,Well> wellHashMap;
    private Map<UserInformation,Vehicle> vehicleHashMap;
    private Map<UserInformation,WereHouse> wereHouseHashMap;
    private ArrayList<UserInformation> users;
    private Map<UserInformation,ArrayList<WildAnimals>> wildAnimalHashmap;
    private Map<UserInformation,Dog> dogHashMap;
    private Map<UserInformation,ArrayList<Cat>> catHashMap;
    public Save(Map<UserInformation,ArrayList<DomesticAnimals>> domesticAnimalsHashMap,Map<UserInformation,ArrayList<Factory>> factoryHashMap,Map<UserInformation,ArrayList<Grass>> grassHashMap,Map<UserInformation,ArrayList<Product>> productHashMap,Map<UserInformation,Well> wellHashMap,Map<UserInformation,Vehicle> vehicleHashMap,Map<UserInformation,WereHouse> wereHouseHashMap,ArrayList<UserInformation> users,Map<UserInformation,ArrayList<WildAnimals>> wildAnimalHashmap,Map<UserInformation,Dog> dogHashMap,Map<UserInformation,ArrayList<Cat>> catHashMap) {
        this.domesticAnimalsHashMap=domesticAnimalsHashMap;
        this.factoryHashMap=factoryHashMap;
        this.grassHashMap=grassHashMap;
        this.productHashMap=productHashMap;
        this.wellHashMap=wellHashMap;
        this.vehicleHashMap=vehicleHashMap;
        this.wereHouseHashMap=wereHouseHashMap;
        this.users=users;
        this.wildAnimalHashmap=wildAnimalHashmap;
        this.dogHashMap=dogHashMap;
        this.catHashMap=catHashMap;
    }
    public void saveFile(){
        Gson gson=new Gson();
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("dog.json"));
            gson.toJson(dogHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("domesticAnimals.json"));
            gson.toJson(domesticAnimalsHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("factory.json"));
            gson.toJson(factoryHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("grass.json"));
            gson.toJson(grassHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("product.json"));
            gson.toJson(productHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("well.json"));
            gson.toJson(wellHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("wereHouse.json"));
            gson.toJson(wereHouseHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("vehicle.json"));
            gson.toJson(vehicleHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File usersFile=new File("users.txt");
        String USERS=gson.toJson(users);
        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter(usersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter1.write(USERS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("wildAnimal.json"));
            gson.toJson(wildAnimalHashmap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Writer writer= Files.newBufferedWriter(Paths.get("cat.json"));
            gson.toJson(catHashMap,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
