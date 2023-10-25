import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Read {
    private Map<UserInformation,ArrayList<DomesticAnimals>> domesticAnimalHashMap;
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
    private Gson gson=new Gson();
    public Read(){
        domesticAnimalHashMap=new HashMap<>();
        factoryHashMap=new HashMap<>();
        grassHashMap=new HashMap<>();
        productHashMap=new HashMap<>();
        wellHashMap=new HashMap<>();
        vehicleHashMap=new HashMap<>();
        wereHouseHashMap=new HashMap<>();
        users=new ArrayList<>();
        wildAnimalHashmap=new HashMap<>();
        dogHashMap=new HashMap<>();
        catHashMap=new HashMap<>();
    }
    public Map<UserInformation, ArrayList<DomesticAnimals>> getDomesticAnimalHashMap()  {
        JsonReader getLocalJsonFile = null;
        try {
            getLocalJsonFile = new JsonReader(new FileReader("domesticAnimals.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type mapTokenType = new TypeToken<HashMap<UserInformation, ArrayList<DomesticAnimals>>>(){}.getType();
        domesticAnimalHashMap = new Gson().fromJson(getLocalJsonFile, mapTokenType);
        return domesticAnimalHashMap;
    }
    public Map<UserInformation, ArrayList<Factory>> getFactoryHashMap() {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("factory.json"));
            factoryHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factoryHashMap;
    }
    public Map<UserInformation, ArrayList<Grass>> getGrassHashMap() {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("grass.json"));
            grassHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grassHashMap;
    }
    public Map<UserInformation, ArrayList<Product>> getProductHashMap () {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("product.json"));
            productHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productHashMap;
    }
    public ArrayList<UserInformation> getUsers () {
        try {
            File usersFile = new File("users.txt");
            Scanner myReader = new Scanner(usersFile);
            String data="";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine()+"\n";
            }
            myReader.close();
                users = gson.fromJson(data, new TypeToken<ArrayList<UserInformation>>() {
                }.getType());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return users;
    }
    public Map<UserInformation,Well> getWellHashMap () {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("well.json"));
            wellHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wellHashMap;
    }
    public Map<UserInformation,Vehicle> getVehicleHashMap () {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("vehicle.json"));
            vehicleHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleHashMap;
    }
    public Map<UserInformation,WereHouse> getWereHouseHashMap () {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("wereHouse.json"));
            wereHouseHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wereHouseHashMap;
    }
    public Map<UserInformation,ArrayList<WildAnimals>> getWildAnimalHashmap () {
        JsonReader getLocalJsonFile = null;
        try {
            getLocalJsonFile = new JsonReader(new FileReader("wildAnimal.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type mapTokenType = new TypeToken<HashMap<UserInformation, ArrayList<WildAnimals>>>(){}.getType();
        wildAnimalHashmap = new Gson().fromJson(getLocalJsonFile, mapTokenType);
        return wildAnimalHashmap;
    }
    public Map<UserInformation,Dog> getDogHashMap () {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("dog.json"));
            dogHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dogHashMap;
    }
    public Map<UserInformation,ArrayList<Cat>> getCatHashMap () {
        Gson gson=new Gson();
        try {
            Reader reader= Files.newBufferedReader(Paths.get("cat.json"));
            catHashMap=gson.fromJson(reader,Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catHashMap;
    }
}
