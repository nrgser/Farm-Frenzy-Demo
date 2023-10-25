import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Manager {
    public static Read read=new Read();
    public static WriteReadMissions writeReadMissions=new WriteReadMissions();
    public static UserInformation user;
    public static String factoryName;
    public static Time currentTime =new Time();
    public static Log log=new Log();
    private Map<UserInformation,ArrayList<DomesticAnimals>> domesticAnimalHashMap;
    private Map<UserInformation,ArrayList<Factory>> factoryHashMap;
    private Map<UserInformation,ArrayList<Grass>> grassHashMap;
    private Map<UserInformation,Well> wellHashMap;
    private Map<UserInformation,Vehicle> vehicleHashMap;
    private Map<UserInformation,WereHouse> wereHouseHashMap;
    private Map<UserInformation,ArrayList<Product>> productHashMap;
    private ArrayList<UserInformation> users;
    private Map<UserInformation,ArrayList<WildAnimals>> wildAnimalHashmap;
    private Map<UserInformation,Dog> dogHashMap;
    private Map<UserInformation,ArrayList<Cat>> catHashMap;
    public Manager(){
        this.domesticAnimalHashMap=read.getDomesticAnimalHashMap();
        this.factoryHashMap=read.getFactoryHashMap();
        this.grassHashMap=read.getGrassHashMap();
        this.wellHashMap=read.getWellHashMap();
        this.vehicleHashMap=read.getVehicleHashMap();
        this.wereHouseHashMap=read.getWereHouseHashMap();
        this.productHashMap=read.getProductHashMap();
        this.users=read.getUsers();
        this.wildAnimalHashmap=read.getWildAnimalHashmap();
        this.dogHashMap=read.getDogHashMap();
        this.catHashMap=read.getCatHashMap();
    }
    public void cage(int x, int y){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        int b=0;
        if(wildAnimalHashmap==null) wildAnimalHashmap=new HashMap<>();
        if(wildAnimalHashmap.get(user)==null) wildAnimalHashmap.put(user,new ArrayList<>());
        if(wereHouseHashMap==null) wereHouseHashMap=new HashMap<>();
        if(wereHouseHashMap.get(user)==null) wereHouseHashMap.put(user,new WereHouse());
        for(int j=0;j<wildAnimalHashmap.get(user).size();j++){
            if(wildAnimalHashmap.get(user).get(j).getX()==x && wildAnimalHashmap.get(user).get(j).getY()==y ){
                if((wildAnimalHashmap.get(user).get(j).getName().equals("Lion") && wildAnimalHashmap.get(user).get(j).getInCage()==3) || ((!wildAnimalHashmap.get(user).get(j).getName().equals("Lion")) && wildAnimalHashmap.get(user).get(j).getInCage()==4)) {
                    if (wereHouseHashMap.get(user).getStorage() + wildAnimalHashmap.get(user).get(j).getStorage() <= 30) {
                        wereHouseHashMap.get(user).setStorage(wereHouseHashMap.get(user).getStorage() + wildAnimalHashmap.get(user).get(j).getStorage());
                        wildAnimalHashmap.get(user).get(j).setCount(wildAnimalHashmap.get(user).get(j).getCount()-1);
                        int a=0;
                        for(int i=0;i<wereHouseHashMap.get(user).getWildAnimals().size();i++){
                            if(wereHouseHashMap.get(user).getWildAnimals().get(i).equals(wildAnimalHashmap.get(user).get(j))){
                                a=1;
                                wereHouseHashMap.get(user).getWildAnimals().get(i).setCount(wereHouseHashMap.get(user).getWildAnimals().get(i).getCount()+1);
                                break;
                            }
                        }if(a==0){
                            try{
                                wereHouseHashMap.get(user).getWildAnimals().add(wildAnimalHashmap.get(user).get(j));
                            }
                            catch (NullPointerException n){
                                wereHouseHashMap=new HashMap<>();
                                wereHouseHashMap.get(user).getWildAnimals().add(wildAnimalHashmap.get(user).get(j));
                            }
                        }
                        if(wildAnimalHashmap.get(user).get(j).getCount()==0){
                            wildAnimalHashmap.get(user).remove(j);
                            log.info("send wild animal in to wereHouse");
                        }
                    } else System.out.println("Your wereHouse is full!");
                }else {
                    wildAnimalHashmap.get(user).get(j).setInCage(wildAnimalHashmap.get(user).get(j).getInCage()+1);
                    System.out.println("You can't get wild animal in the cage yet!");
                    log.info("put wild animal into cage");
                }
                b=1;
                break;
            }
        }
        if(b==0){
            System.out.println("Wrong input!");
            log.error("Error in putting wild animal into cage");
        }
        logOut();
    }
    public void signUp(String userName,int pass) throws Exception {
        int a=0;
        if (users != null) {
            for (UserInformation  u: users) {
                if (u.getUserName().equals(userName)) {
                    user=u;
                    a=1;
                    throw new Exception("This username has already been used");
                }
            }
        }
        if(a==0) {
            user = new UserInformation(userName, pass);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            user.setLastEdit(dtf.format(now));
            log.header(user.getAddDate(),user.getUserName(),user.getLastEdit());
            log.info("Entered the game");
            try{
                users.add(user);
            }
            catch (NullPointerException n){
                users=new ArrayList<>();
                users.add(user);
            }
        }else{
            while (true){
                // pass=scanner.nextInt();
                if(user.getPassword()==pass){
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    user.setLastEdit(dtf.format(now));
                    log.header(user.getAddDate(),user.getUserName(),user.getLastEdit());
                    log.info("Entered the game");
                    break;
                }else{
                    throw new Exception("wrong pass!");
                }
            }
        }
        logOut();

    }
    public boolean logIn(String userName,int pass) throws Exception {
        boolean check=false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        for (UserInformation  user: users) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword()==pass){
                    check=true;
                }
                else {throw new Exception("wrong pass!"); } }
            else{ throw new Exception("wrong pass!"); }
        } if(check==true){
            log.header(user.getAddDate(),user.getUserName(),user.getLastEdit());
            log.info("Entered the game");
        }else{
            log.error("Wrong password");
        }
        return check;
    }
    public boolean start(int level){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(level>user.getLevels()){
            System.out.println("This Level is locked for you!");
            log.error("Level is locked");
            return false;
        }
        else {
            log.info("Star the "+level);
            return true;
        }
    }
    public void levelCheck(int level){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        List<Missions> missions = null;
        writeReadMissions.read(missions);
        for (Missions m:missions) {
            if (m.getLevel() == level) {
                for (int i = 0; i < productHashMap.get(user).size(); i++) {
                    for (int j = 0; j < m.getTask().size(); j++) {
                        for (int k = 0; k < domesticAnimalHashMap.get(user).size(); k++) {
                            if (m.getTask().containsKey(productHashMap.get(user).get(i).getName())||m.getTask().containsKey(domesticAnimalHashMap.get(user).get(k).getName()))
                            {
                                if (m.getTask().containsValue(productHashMap.get(user).get(i).getCounter())||m.getTask().containsValue(domesticAnimalHashMap.get(user).get(k).getCounter())){
                                    m.setCheckComplete(true);
                                }
                            }

                        }
                    }
                }
                if (m.isCheckComplete()){
                    if (m.getMaxTime()==currentTime.getTime()){
                        user.setCoins(user.getCoins()+m.getGift());
                    }
                    System.out.println("YOU WON");
                    log.info("Win the game");
                }

            }
        }
    }
    public void buyDomesticAnimal(String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(name.equals("buffalo")){
            Buffalo d=new Buffalo();
            d.setTime(currentTime.getTime());
            d.setGrassHashMap(grassHashMap);
            d.setProductHashMap(productHashMap);
            d.setUser(user);
            d.setCounter(d.getCounter()+1);
            user.setCoins(user.getCoins()-d.getPrice());
            try {
                domesticAnimalHashMap.get(user).add(d);
            }
            catch (NullPointerException n){
                domesticAnimalHashMap=new HashMap<>();
                try{
                    domesticAnimalHashMap.get(user).add(d);
                }catch (NullPointerException e){
                    domesticAnimalHashMap.put(user,new ArrayList<>());
                    domesticAnimalHashMap.get(user).add(d);
                }
            }
            log.info("Buy Buffalo");
        }else if(name.equals("chicken")){
            Chicken d=new Chicken();
            d.setTime(currentTime.getTime());
            d.setGrassHashMap(grassHashMap);
            d.setProductHashMap(productHashMap);
            d.setUser(user);
            d.setCounter(d.getCounter()+1);
            user.setCoins(user.getCoins()-d.getPrice());
            try {
                domesticAnimalHashMap.get(user).add(d);
            }
            catch (NullPointerException n){
                domesticAnimalHashMap=new HashMap<>();
                try{
                    domesticAnimalHashMap.get(user).add(d);
                }catch (NullPointerException e){
                    domesticAnimalHashMap.put(user,new ArrayList<>());
                    domesticAnimalHashMap.get(user).add(d);
                }
            }
            log.info("Buy Chicken");
        }else if(name.equals("ostrich")){
            Ostrich d=new Ostrich();
            d.setTime(currentTime.getTime());
            d.setGrassHashMap(grassHashMap);
            d.setProductHashMap(productHashMap);
            d.setUser(user);
            d.setCounter(d.getCounter()+1);
            user.setCoins(user.getCoins()-d.getPrice());
            try {
                domesticAnimalHashMap.get(user).add(d);
            }
            catch (NullPointerException n){
                domesticAnimalHashMap=new HashMap<>();
                try{
                    domesticAnimalHashMap.get(user).add(d);
                }catch (NullPointerException e){
                    domesticAnimalHashMap.put(user,new ArrayList<>());
                    domesticAnimalHashMap.get(user).add(d);
                }
            }
            log.info("Buy Ostrich");
        }else {
            System.out.println("Wrong name!");
            log.error("wrong animal name for buying");
        }
        logOut();
    }
    public void buyCat(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        Cat c=new Cat();
        c.setTime(currentTime.getTime());
        c.setWereHouseHashMap(wereHouseHashMap);
        c.setUser(user);
        c.setProductHashmap(productHashMap);
        user.setCoins(user.getCoins()-c.getPrice());
        try {
            catHashMap.get(user).add(c);
        }
        catch (NullPointerException n){
            catHashMap=new HashMap<>();
            if(catHashMap.get(user)==null){
                catHashMap.put(user,new ArrayList<>());
            }
            catHashMap.get(user).add(c);
        }
        log.info("Buy Cat");
        logOut();
    }
    public void buyDog(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        Dog d=new Dog();
        d.setTime(currentTime.getTime());
        d.setDogHashMap(dogHashMap);
        d.setWildAnimalsHashMap(wildAnimalHashmap);
        d.setWereHouseHashMap(wereHouseHashMap);
        d.setUser(user);
        user.setCoins(user.getCoins()-d.getPrice());
        try {
            dogHashMap.put(user,d);
        }
        catch (NullPointerException n){
            dogHashMap=new HashMap<>();
            dogHashMap.put(user,d);
        }
        log.info("Buy Dog");
        logOut();
    }
    public void pickUp(int x, int y){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(productHashMap== null) productHashMap=new HashMap<>();
        if(productHashMap.get(user)==null) productHashMap.put(user,new ArrayList<>());
        if(!productHashMap.get(user).isEmpty()) {
            int a=0;
            for(int i=0;i<productHashMap.get(user).size();i++){
                if(productHashMap.get(user).get(i).getX()==x && productHashMap.get(user).get(i).getY()==y){
                    String item=productHashMap.get(user).get(i).getName();
                    sendProductToWereHouse(item);
                    a=1;
                    log.info("Pick up a product");
                    break;
                }
            }if(a==0) {
                System.out.println("There is no product in this point!");
                log.error("can't pick up product from this point");
            }
        }else {
            System.out.println("There is no product in this field!");
            log.error("can't find any product in this field");
        }
        logOut();
    }
    public void chargeWell(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(wellHashMap==null) wellHashMap=new HashMap<>();
        if(wellHashMap.get(user).getCapacity()==0){
            wellHashMap.get(user).setTime(currentTime.getTime());
            if (wellHashMap.get(user).isCheckTime()){
                wellHashMap.get(user).setCapacity(5);
                log.info("Well is charged");
            }
        }else{
            log.error("Well wasn't empty yet");
        }
        logOut();
    }
    public void plant(int x, int y){
        if(wellHashMap==null) wellHashMap=new HashMap<>();
        if(grassHashMap==null) grassHashMap=new HashMap<>();
        if(grassHashMap.get(user)==null ) grassHashMap.put(user,new ArrayList<>());
        if(wellHashMap.get(user).getCapacity()>0){
            wellHashMap.get(user).setCapacity(wellHashMap.get(user).getCapacity()-1);
            grassHashMap.get(user).add(new Grass(x,y));
            log.info("Plant Grass");
        }else{
            System.out.println("You need to charge well!");
            log.error("Well was empty, so You can't plant Grass");
        }
        logOut();
    }
    public void workActive(String factory){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(factoryHashMap==null) factoryHashMap=new HashMap<>();
        if(factoryHashMap.get(user)==null) factoryHashMap.put(user,new ArrayList<>());
        if(factory.equals("breadfactory")) {
            for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                if(factoryHashMap.get(user).get(j).getName().equals("BreadFactory")) {
                    factoryHashMap.get(user).get(j).setTime(currentTime.getTime());
                    factoryHashMap.get(user).get(j).setActivation(true);
                    log.info("Bread Factory starts working");
                    break;
                }
            }
        }else if(factory.equals("clothfactory")){
            for(int j=0;j<factoryHashMap.get(user).size();j++) {
                if(factoryHashMap.get(user).get(j).getName().equals("ClothFactory")) {
                    factoryHashMap.get(user).get(j).setTime(currentTime.getTime());
                    factoryHashMap.get(user).get(j).setActivation(true);
                    log.info("Cloth Factory starts working");
                    break;
                }
            }
        }else if(factory.equals("flourfactory")){
            for(int j=0;j<factoryHashMap.get(user).size();j++) {
                if(factoryHashMap.get(user).get(j).getName().equals("FlourFactory")) {
                    factoryHashMap.get(user).get(j).setTime(currentTime.getTime());
                    factoryHashMap.get(user).get(j).setActivation(true);
                    log.info("Flour Factory starts working");
                    break;
                }
            }
        }else if(factory.equals("icecreamfactory")){
            for(int j=0;j<factoryHashMap.get(user).size();j++) {
                if(factoryHashMap.get(user).get(j).getName().equals("IceCreamFactory")) {
                    factoryHashMap.get(user).get(j).setTime(currentTime.getTime());
                    factoryHashMap.get(user).get(j).setActivation(true);
                    log.info("IceCream Factory starts working");
                    break;
                }
            }
        }else if(factory.equals("milkpackagingfactory")){
            for(int j=0;j<factoryHashMap.get(user).size();j++) {
                if(factoryHashMap.get(user).get(j).getName().equals("MilkPackagingFactory")) {
                    factoryHashMap.get(user).get(j).setTime(currentTime.getTime());
                    factoryHashMap.get(user).get(j).setActivation(true);
                    log.info("Milk Packaging Factory starts working");
                    break;
                }
            }
        }else if(factory.equals("shirtfactory")){
            for(int j=0;j<factoryHashMap.get(user).size();j++) {
                if(factoryHashMap.get(user).get(j).getName().equals("ShirtFactory")) {
                    factoryHashMap.get(user).get(j).setTime(currentTime.getTime());
                    factoryHashMap.get(user).get(j).setActivation(true);
                    log.info("Shirt Factory starts working");
                    break;
                }
            }
        }else {
            System.out.println("There is no Factory with this name!");
            log.error("Wrong Factory name to work");
        }
        logOut();
    }
    public void turn(int n){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(grassHashMap==null) grassHashMap=new HashMap<>();
        if(grassHashMap.get(user)==null) grassHashMap.put(user,new ArrayList<>());
        if(dogHashMap==null) dogHashMap=new HashMap<>();
        if(domesticAnimalHashMap==null) domesticAnimalHashMap=new HashMap<>();
        if(domesticAnimalHashMap.get(user)==null) domesticAnimalHashMap.put(user,new ArrayList<>());
        if(catHashMap==null) catHashMap=new HashMap<>();
        if(catHashMap.get(user)==null) catHashMap.put(user,new ArrayList<>());
        if(wildAnimalHashmap==null) wildAnimalHashmap=new HashMap<>();
        if(wildAnimalHashmap.get(user)==null) wildAnimalHashmap.put(user,new ArrayList<>());
        if(productHashMap==null) productHashMap=new HashMap<>();
        if(productHashMap.get(user)==null) productHashMap.put(user,new ArrayList<>());
        for (int i = 0; i <n ; i++) {
            turner();
        }
        System.out.println("Grass:");
        if(grassHashMap.get(user).isEmpty()) System.out.println("There is no Grass in this field!");
        else {
            for (int i = 0; i < grassHashMap.get(user).size(); i++) {
                System.out.println("There is Grass in X: " + grassHashMap.get(user).get(i).getX() + " Y: " + grassHashMap.get(user).get(i).getY());
            }
            for(int i=0;i<6;i++){
                System.out.println("-");
            }
            for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    int a=0;
                    for(int t=0;t<grassHashMap.get(user).size();t++) {
                        if (grassHashMap.get(user).get(t).getX() == i && grassHashMap.get(user).get(t).getY() == j) {
                            a++;
                        }
                    }if(a>0) {
                        System.out.println(a);
                    }else{
                        System.out.println(" ");
                    }
                }
            }
            for(int i=0;i<6;i++){
                System.out.println("-");
            }
        }
        System.out.println("Domestic Animals:");
        if(domesticAnimalHashMap.get(user).isEmpty() && dogHashMap.get(user)==null && catHashMap.get(user).isEmpty()) System.out.println("There is no Domestic Animal in this field!");
        else{
            for(int i=0;i<domesticAnimalHashMap.get(user).size();i++){
                System.out.println(domesticAnimalHashMap.get(user).get(i).getName()+" "+domesticAnimalHashMap.get(user).get(i).getHealth()+"% "+domesticAnimalHashMap.get(user).get(i).getX()+" "+domesticAnimalHashMap.get(user).get(i).getY());
            }
        }
        if(dogHashMap.get(user)!=null){
            System.out.println("Dog "+dogHashMap.get(user).getX()+" "+dogHashMap.get(user).getY());
        }
        if(!catHashMap.get(user).isEmpty()){
            for(int i=0;i<catHashMap.get(user).size();i++){
                System.out.println("Cat "+catHashMap.get(user).get(i).getX()+" "+catHashMap.get(user).get(i).getY());
            }
        }
        System.out.println("Wild Animals:");
        if(wildAnimalHashmap.get(user).isEmpty()) System.out.println("There is no wild animal in this field!");
        else{
            for(int i=0;i<wildAnimalHashmap.get(user).size();i++){
                System.out.println(wildAnimalHashmap.get(user).get(i).getName()+" "+wildAnimalHashmap.get(user).get(i).getInCage()+" "+wildAnimalHashmap.get(user).get(i).getX()+" "+wildAnimalHashmap.get(user).get(i).getY());
            }
        }
        System.out.println("Products:");
        if(productHashMap.get(user).isEmpty()) System.out.println("There is no product in this field!");
        else{
            for(int i=0;i<productHashMap.get(user).size();i++){
                System.out.println(productHashMap.get(user).get(i).getName()+" "+productHashMap.get(user).get(i).getX()+" "+productHashMap.get(user).get(i).getY());
            }
        }
        log.info("Use Turn "+n);
        logOut();
    }
    public void turner(){
        currentTime.setTime(currentTime.getTime()+1);
        disappearProduct(currentTime.getTime());
        walk();
        decreaseHealth(currentTime.getTime());
        checkTimeFactory(currentTime.getTime());//
        checkTimeWell(currentTime.getTime());//
        checkTimeTruck(currentTime.getTime());//
        checkProductTime(currentTime.getTime());
        chargeWell();
        produce();
        dieDomesticAnimal();
        levelCheck(user.getLevels());
        logOut();
    }
    public void produce(){
        if(domesticAnimalHashMap==null) domesticAnimalHashMap=new HashMap<>();
        if(domesticAnimalHashMap.get(user)==null) domesticAnimalHashMap.put(user,new ArrayList<>());
        for (int i = 0; i < domesticAnimalHashMap.get(user).size(); i++) {
            domesticAnimalHashMap.get(user).get(i).produced();
        }
        logOut();
    }
    public void checkProductTime(int currentTime){
        if(domesticAnimalHashMap==null) domesticAnimalHashMap=new HashMap<>();
        if(domesticAnimalHashMap.get(user)==null) domesticAnimalHashMap.put(user,new ArrayList<>());
        for (int i = 0; i < domesticAnimalHashMap.get(user).size(); i++) {
            if((currentTime-domesticAnimalHashMap.get(user).get(i).getTime()==2 && domesticAnimalHashMap.get(user).get(i).getPrice()==100)||(currentTime-domesticAnimalHashMap.get(user).get(i).getTime()==3 && domesticAnimalHashMap.get(user).get(i).getPrice()==200)||(currentTime-domesticAnimalHashMap.get(user).get(i).getTime()==5 && domesticAnimalHashMap.get(user).get(i).getPrice()==400)){
                domesticAnimalHashMap.get(user).get(i).setTimeChecked(true);
            }
        }
        logOut();
    }
    public void disappearProduct(int currentTime) {
        if(productHashMap==null) productHashMap=new HashMap<>();
        if(productHashMap.get(user)==null) productHashMap.put(user,new ArrayList<>());
        if(wildAnimalHashmap==null) wildAnimalHashmap=new HashMap<>();
        if(wildAnimalHashmap.get(user)==null) wildAnimalHashmap.put(user,new ArrayList<>());
        for (int i = 0; i < productHashMap.get(user).size(); i++) {
            if (productHashMap.get(user).get(i).getPrice() == 15 || productHashMap.get(user).get(i).getPrice() == 20|| productHashMap.get(user).get(i).getPrice() == 25) {
                if (currentTime - productHashMap.get(user).get(i).getStartTime() == 4) {
                    productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                    if (productHashMap.get(user).get(i).getCount() == 0) {
                        productHashMap.get(user).remove(i);
                    }

                }
            }
            if (productHashMap.get(user).get(i).getPrice() == 40 || productHashMap.get(user).get(i).getPrice() == 50 || productHashMap.get(user).get(i).getPrice() == 60) {
                if (currentTime - productHashMap.get(user).get(i).getStartTime() == 5) {
                    productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                    if (productHashMap.get(user).get(i).getCount() == 0) {
                        productHashMap.get(user).remove(i);
                    }
                }
            }if (productHashMap.get(user).get(i).getPrice() == 80 || productHashMap.get(user).get(i).getPrice() == 100 ||productHashMap.get(user).get(i).getPrice() == 120){
                if (currentTime - productHashMap.get(user).get(i).getStartTime() == 6) {
                    productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                    if (productHashMap.get(user).get(i).getCount() == 0) {
                        productHashMap.get(user).remove(i);
                    }

                }
            }
        }
        for (int i = 0; i <wildAnimalHashmap.get(user).size() ; i++) {
            if (currentTime-wildAnimalHashmap.get(user).get(i).getStartingInCage()==5){
                wildAnimalHashmap.get(user).get(i).setCount(wildAnimalHashmap.get(user).get(i).getCount() - 1);
                if (wildAnimalHashmap.get(user).get(i).getCount() == 0) {
                    wildAnimalHashmap.get(user).remove(i);
                }
            }

        }
        logOut();
    }
    public void walk(){
        if(domesticAnimalHashMap==null) domesticAnimalHashMap=new HashMap<>();
        if(domesticAnimalHashMap.get(user)==null) domesticAnimalHashMap.put(user,new ArrayList<>());
        if(wildAnimalHashmap==null) wildAnimalHashmap=new HashMap<>();
        if(wildAnimalHashmap.get(user)==null) wildAnimalHashmap.put(user,new ArrayList<>());
        if(catHashMap==null) catHashMap=new HashMap<>();
        if(catHashMap.get(user)==null) catHashMap.put(user,new ArrayList<>());
        if(dogHashMap==null) dogHashMap=new HashMap<>();
        for (int i = 0; i <domesticAnimalHashMap.get(user).size() ; i++) {
            domesticAnimalHashMap.get(user).get(i).walk(); }
        for (int i = 0; i <wildAnimalHashmap.get(user).size() ; i++) {
            wildAnimalHashmap.get(user).get(i).walk(); }
        for (int i = 0; i <catHashMap.get(user).size() ; i++) {
            catHashMap.get(user).get(i).walk(); }
        dogHashMap.get(user).walk();
        logOut();
    }
    public void decreaseHealth(int currentTime){
        if(domesticAnimalHashMap==null) domesticAnimalHashMap=new HashMap<>();
        if(domesticAnimalHashMap.get(user)==null) domesticAnimalHashMap.put(user,new ArrayList<>());
        for (int i = 0; i <domesticAnimalHashMap.get(user).size() ; i++) {
            domesticAnimalHashMap.get(user).get(i).setHealth(domesticAnimalHashMap.get(user).get(i).getHealth()-10);
        }
        logOut();
    }
    public void checkTimeTruck(int currentTime){
        if(vehicleHashMap==null) vehicleHashMap=new HashMap<>();
        if (currentTime-vehicleHashMap.get(user).getStartTime()==10){
            vehicleHashMap.get(user).setCheckTime(true);
        }
        logOut();
    }
    public void checkTimeFactory(int currentTime) {
        int a = 0;
        if(factoryHashMap==null) factoryHashMap=new HashMap<>();
        if(factoryHashMap.get(user)==null) factoryHashMap.put(user,new ArrayList<>());
        if(productHashMap==null) productHashMap=new HashMap<>();
        if(productHashMap.get(user)==null) productHashMap.put(user,new ArrayList<>());
        for (int m = 0; m < factoryHashMap.get(user).size(); m++) {
            if (currentTime - factoryHashMap.get(user).get(m).getTime() == factoryHashMap.get(user).get(m).getMaxTime()) {
                factoryHashMap.get(user).get(m).setCheckTime(true);
                if (factoryHashMap.get(user).get(m).isActivation()) {
                    for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                        if (factoryHashMap.get(user).get(j).getInputProduct().equals("flour")) {
                            for (int i = 0; i < productHashMap.get(user).size(); i++) {
                                if (productHashMap.get(user).get(i).getPrice() == 40) {
                                    if (factoryHashMap.get(user).get(i).isCheckTime()) {
                                        if (productHashMap.get(user).get(i).getCount() > 1) {
                                            productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                                        } else {
                                            productHashMap.get(user).remove(i);
                                        }
                                        int b = 0;
                                        for (int k = 0; k < productHashMap.get(user).size(); k++) {
                                            if (productHashMap.get(user).get(k).getPrice() == 80) {
                                                productHashMap.get(user).get(k).setCount(productHashMap.get(user).get(k).getCount() + 1);
                                                b = 1;
                                            }
                                        }
                                        if (b == 0) {
                                            Bread bread = new Bread();
                                            bread.setCounter(bread.getCounter()+1);
                                            productHashMap.get(user).add(bread);
                                        }
                                        a = 1;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (a == 0) System.out.println("Error!");
                } else if (factoryHashMap.get(user).get(m).isActivation()) {
                    for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                        if (factoryHashMap.get(user).get(j).getInputProduct().equals("feather")) {
                            for (int i = 0; i < productHashMap.get(user).size(); i++) {
                                if (productHashMap.get(user).get(i).getPrice() == 20) {
                                    if (factoryHashMap.get(user).get(i).isCheckTime()) {
                                        if (productHashMap.get(user).get(i).getCount() > 1) {
                                            productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                                        } else {
                                            productHashMap.get(user).remove(i);
                                        }
                                        int b = 0;
                                        for (int k = 0; k < productHashMap.get(user).size(); k++) {
                                            if (productHashMap.get(user).get(k).getPrice() == 50) {
                                                productHashMap.get(user).get(k).setCount(productHashMap.get(user).get(k).getCount() + 1);
                                                b = 1;
                                            }
                                        }
                                        if (b == 0) {
                                            Cloth cloth = new Cloth();
                                            cloth.setCounter(cloth.getCounter()+1);
                                            productHashMap.get(user).add(cloth);
                                        }
                                        a = 1;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (a == 0) System.out.println("Error!");
                } else if (factoryHashMap.get(user).get(m).isActivation()) {
                    for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                        if (factoryHashMap.get(user).get(j).getInputProduct().equals("egg")) {
                            for (int i = 0; i < productHashMap.get(user).size(); i++) {
                                if (productHashMap.get(user).get(i).getPrice() == 15) {
                                    if (factoryHashMap.get(user).get(i).isCheckTime()) {
                                        if (productHashMap.get(user).get(i).getCount() > 1) {
                                            productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                                        } else {
                                            productHashMap.get(user).remove(i);
                                        }
                                        int b = 0;
                                        for (int k = 0; k < productHashMap.get(user).size(); k++) {
                                            if (productHashMap.get(user).get(k).getPrice() == 40) {
                                                productHashMap.get(user).get(k).setCount(productHashMap.get(user).get(k).getCount() + 1);
                                                b = 1;
                                            }
                                        }
                                        if (b == 0) {
                                            Flour flour = new Flour();
                                            flour.setCounter(flour.getCounter()+1);
                                            productHashMap.get(user).add(flour);
                                        }
                                        a = 1;
                                        break;
                                    }
                                }

                            }
                            break;
                        }
                    }
                    if (a == 0) System.out.println("Error!");
                }
                else   if (factoryHashMap.get(user).get(m).isActivation()) {
                    for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                        if (factoryHashMap.get(user).get(j).getInputProduct().equals("packaged milk")) {
                            for (int i = 0; i < productHashMap.get(user).size(); i++) {
                                if (productHashMap.get(user).get(i).getPrice() == 60) {
                                    if (factoryHashMap.get(user).get(i).isCheckTime()) {
                                        if (productHashMap.get(user).get(i).getCount() > 1) {
                                            productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                                        } else {
                                            productHashMap.get(user).remove(i);
                                        }
                                        int b = 0;
                                        for (int k = 0; k < productHashMap.get(user).size(); k++) {
                                            if (productHashMap.get(user).get(k).getPrice() == 120) {
                                                productHashMap.get(user).get(k).setCount(productHashMap.get(user).get(k).getCount() + 1);
                                                b = 1;
                                            }
                                        }
                                        if (b == 0) {
                                            //check kone vahed zamani if mikhaym
                                            IceCream iceCream = new IceCream();
                                            iceCream.setCounter(iceCream.getCounter()+1);
                                            productHashMap.get(user).add(iceCream);
                                        }
                                        a = 1;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (a == 0) System.out.println("Error!");
                } else   if (factoryHashMap.get(user).get(m).isActivation()) {
                    for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                        if (factoryHashMap.get(user).get(j).getInputProduct().equals("milk")) {
                            for (int i = 0; i < productHashMap.get(user).size(); i++) {
                                if (productHashMap.get(user).get(i).getPrice() == 25) {
                                    if (factoryHashMap.get(user).get(i).isCheckTime()) {
                                        if (productHashMap.get(user).get(i).getCount() > 1) {
                                            productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                                        } else {
                                            productHashMap.get(user).remove(i);
                                        }
                                        int b = 0;
                                        for (int k = 0; k < productHashMap.get(user).size(); k++) {
                                            if (productHashMap.get(user).get(k).getPrice() == 60) {
                                                productHashMap.get(user).get(k).setCount(productHashMap.get(user).get(k).getCount() + 1);
                                                b = 1;
                                            }
                                        }
                                        if (b == 0) {
                                            PackagedMilk packagedMilk = new PackagedMilk();
                                            packagedMilk.setCounter(packagedMilk.getCounter()+1);
                                            productHashMap.get(user).add(packagedMilk);
                                        }
                                        a = 1;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (a == 0) System.out.println("Error!");
                } else   if (factoryHashMap.get(user).get(m).isActivation()) {
                    for (int j = 0; j < factoryHashMap.get(user).size(); j++) {
                        if (factoryHashMap.get(user).get(j).getInputProduct().equals("cloth")) {
                            for (int i = 0; i < productHashMap.get(user).size(); i++) {
                                if (productHashMap.get(user).get(i).getPrice() == 50) {
                                    if (factoryHashMap.get(user).get(i).isCheckTime()) {
                                        if (productHashMap.get(user).get(i).getCount() > 1) {
                                            productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount() - 1);
                                        } else {
                                            productHashMap.get(user).remove(i);
                                        }
                                        int b = 0;
                                        for (int k = 0; k < productHashMap.get(user).size(); k++) {
                                            if (productHashMap.get(user).get(k).getPrice() == 100) {
                                                productHashMap.get(user).get(k).setCount(productHashMap.get(user).get(k).getCount() + 1);
                                                b = 1;
                                            }
                                        }
                                        if (b == 0) {
                                            Shirt shirt = new Shirt();
                                            shirt.setCounter(shirt.getCounter()+1);
                                            productHashMap.get(user).add(shirt);
                                        }
                                        a = 1;
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (a == 0) System.out.println("Error!");
                } else System.out.println("There is no Factory with this name!");
            }
            break;
        }
        logOut();
    }
    public void checkTimeWell(int currentTime){
        if(wellHashMap==null) wellHashMap=new HashMap<>();
        if (currentTime - wellHashMap.get(user).getStartTime() == 3) {
            wellHashMap.get(user).setCheckTime(true);
        }
        logOut();
    }
    public void truckLoad(String item){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        int a=0;
        if(wereHouseHashMap==null) wereHouseHashMap=new HashMap<>();
        if(vehicleHashMap==null) vehicleHashMap=new HashMap<>();
        for(int i=0;i<wereHouseHashMap.get(user).getProducts().size();i++){
            if(wereHouseHashMap.get(user).getProducts().get(i).getName().equals(item)){
                a=1;
                if(vehicleHashMap.get(user).getCapacity()+wereHouseHashMap.get(user).getProducts().get(i).getStorage()<=15){
                    vehicleHashMap.get(user).setCapacity(vehicleHashMap.get(user).getCapacity()+wereHouseHashMap.get(user).getProducts().get(i).getStorage());
                    user.setCoins(user.getCoins()+wereHouseHashMap.get(user).getProducts().get(i).getPrice());
                    int c=0;
                    for(int j=0;j<vehicleHashMap.get(user).getProducts().size();j++){
                        if(vehicleHashMap.get(user).getProducts().get(j).getName().equals(item)){
                            c=1;
                            vehicleHashMap.get(user).getProducts().get(j).setCount(vehicleHashMap.get(user).getProducts().get(j).getCount()+1);
                            break;
                        }
                    }if(c==0){
                        try {
                            vehicleHashMap.get(user).getProducts().add(wereHouseHashMap.get(user).getProducts().get(i));
                        }
                        catch (NullPointerException n){
                            vehicleHashMap=new HashMap<>();
                            vehicleHashMap.get(user).getProducts().add(wereHouseHashMap.get(user).getProducts().get(i));
                        }
                    }
                    if(wereHouseHashMap.get(user).getProducts().get(i).getCount()>1){
                        wereHouseHashMap.get(user).getProducts().get(i).setCount(wereHouseHashMap.get(user).getProducts().get(i).getCount()-1);
                    }else {
                        wereHouseHashMap.get(user).getProducts().remove(i);
                    }
                    log.info("send product to vehicle");
                }else {
                    System.out.println("Vehicle doesn't have enough space!");
                    log.error("vehicle doesn't have enough space");
                }
                break;
            }
        }
        if(a==0) {
            for (int i = 0; i < wereHouseHashMap.get(user).getWildAnimals().size(); i++) {
                if(wereHouseHashMap.get(user).getWildAnimals().get(i).getName().equals(item)){
                    a=1;
                    if(vehicleHashMap.get(user).getCapacity()+wereHouseHashMap.get(user).getWildAnimals().get(i).getStorage()<=15){
                        vehicleHashMap.get(user).setCapacity(vehicleHashMap.get(user).getCapacity()+wereHouseHashMap.get(user).getWildAnimals().get(i).getStorage());
                        user.setCoins(user.getCoins()+wereHouseHashMap.get(user).getWildAnimals().get(i).getPrice());
                        int c=0;
                        for(int j=0;j<vehicleHashMap.get(user).getWildAnimals().size();j++){
                            if(vehicleHashMap.get(user).getWildAnimals().get(j).getName().equals(item)){
                                c=1;
                                vehicleHashMap.get(user).getWildAnimals().get(j).setCount(vehicleHashMap.get(user).getWildAnimals().get(j).getCount()+1);
                                break;
                            }
                        }if(c==0){
                            try {
                                vehicleHashMap.get(user).getWildAnimals().add(wereHouseHashMap.get(user).getWildAnimals().get(i));
                            }
                            catch (NullPointerException n){
                                vehicleHashMap=new HashMap<>();
                                vehicleHashMap.get(user).getWildAnimals().add(wereHouseHashMap.get(user).getWildAnimals().get(i));
                            }
                        }
                        if(wereHouseHashMap.get(user).getWildAnimals().get(i).getCount()>1){
                            wereHouseHashMap.get(user).getWildAnimals().get(i).setCount(wereHouseHashMap.get(user).getWildAnimals().get(i).getCount()-1);
                        }else {
                            wereHouseHashMap.get(user).getWildAnimals().remove(i);
                        }
                        log.info("send wild animal to vehicle");
                    }else {
                        System.out.println("Vehicle doesn't have enough space!");
                        log.error("vehicle doesn't have enough space");
                    }
                    break;
                }
            }
        }if(a==0) {
            System.out.println("Wrong input!");
            log.error("Wrong input in truck load");
        }
        logOut();
    }
    public void truckGo(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        checkTimeTruck(currentTime.getTime());
        log.info("truck starts going");
        logOut();
    }
    public void truckUnLoad(String item){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(vehicleHashMap==null) vehicleHashMap=new HashMap<>();
        if(wereHouseHashMap==null) wereHouseHashMap=new HashMap<>();
        int a=0;
        for(int i=0;i<vehicleHashMap.get(user).getProducts().size();i++){
            if(vehicleHashMap.get(user).getProducts().get(i).getName().equals(item)){
                a=1;
                if(wereHouseHashMap.get(user).getStorage()+vehicleHashMap.get(user).getProducts().get(i).getStorage()<=15){
                    wereHouseHashMap.get(user).setStorage(wereHouseHashMap.get(user).getStorage()+vehicleHashMap.get(user).getProducts().get(i).getStorage());
                    user.setCoins(user.getCoins()-vehicleHashMap.get(user).getProducts().get(i).getPrice());
                    int c=0;
                    for(int j=0;j<wereHouseHashMap.get(user).getProducts().size();j++){
                        if(wereHouseHashMap.get(user).getProducts().get(j).getName().equals(item)){
                            c=1;
                            wereHouseHashMap.get(user).getProducts().get(j).setCount(wereHouseHashMap.get(user).getProducts().get(j).getCount()+1);
                            break;
                        }
                    }if(c==0){
                        try {
                            wereHouseHashMap.get(user).getProducts().add(vehicleHashMap.get(user).getProducts().get(i));
                        }
                        catch (NullPointerException n){
                            wereHouseHashMap=new HashMap<>();
                            wereHouseHashMap.get(user).getProducts().add(vehicleHashMap.get(user).getProducts().get(i));
                        }
                    }
                    if(vehicleHashMap.get(user).getProducts().get(i).getCount()>1){
                        vehicleHashMap.get(user).getProducts().get(i).setCount(vehicleHashMap.get(user).getProducts().get(i).getCount()-1);
                    }else {
                        vehicleHashMap.get(user).getProducts().remove(i);
                    }
                    log.info("unload product");
                }else {
                    System.out.println("werehouse doesn't have enough space!");
                    log.error("werehouse is full, you can't unload");
                }
                break;
            }
        }
        if(a==0) {
            for (int i = 0; i < vehicleHashMap.get(user).getWildAnimals().size(); i++) {
                if(vehicleHashMap.get(user).getWildAnimals().get(i).getName().equals(item)){
                    a=1;
                    if(wereHouseHashMap.get(user).getStorage()+vehicleHashMap.get(user).getWildAnimals().get(i).getStorage()<=15){
                        wereHouseHashMap.get(user).setStorage(wereHouseHashMap.get(user).getStorage()+vehicleHashMap.get(user).getWildAnimals().get(i).getStorage());
                        user.setCoins(user.getCoins()-vehicleHashMap.get(user).getWildAnimals().get(i).getPrice());
                        int c=0;
                        for(int j=0;j<wereHouseHashMap.get(user).getWildAnimals().size();j++){
                            if(wereHouseHashMap.get(user).getWildAnimals().get(j).getName().equals(item)){
                                c=1;
                                wereHouseHashMap.get(user).getWildAnimals().get(j).setCount(wereHouseHashMap.get(user).getWildAnimals().get(j).getCount()+1);
                                break;
                            }
                        }if(c==0){
                            try {
                                wereHouseHashMap.get(user).getWildAnimals().add(vehicleHashMap.get(user).getWildAnimals().get(i));
                            }
                            catch (NullPointerException n){
                                wereHouseHashMap=new HashMap<>();
                                wereHouseHashMap.get(user).getWildAnimals().add(vehicleHashMap.get(user).getWildAnimals().get(i));
                            }
                        }
                        if(vehicleHashMap.get(user).getWildAnimals().get(i).getCount()>1){
                            vehicleHashMap.get(user).getWildAnimals().get(i).setCount(vehicleHashMap.get(user).getWildAnimals().get(i).getCount()-1);
                        }else {
                            vehicleHashMap.get(user).getWildAnimals().remove(i);
                        }
                        log.info("unload wild animal");
                    }else {
                        System.out.println("werehouse doesn't have enough space!");
                        log.error("werehouse is full, you can't unload");
                    }
                    break;
                }
            }
        }if(a==0) {
            System.out.println("Wrong input!");
            log.error("wrong input in unload truck");
        }
        logOut();
    }
    public void wildAnimalCome(){
        Random random=new Random();
        int j=random.nextInt(10)+1;
        if(j>9) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            user.setLastEdit(dtf.format(now));
            int i = random.nextInt(3) + 1;
            if(wildAnimalHashmap==null) wildAnimalHashmap=new HashMap<>();
            if(wildAnimalHashmap.get(user)==null) wildAnimalHashmap.put(user,new ArrayList<>());
            if (i == 1) {
                int a=0;
                for(int t=0;t<wildAnimalHashmap.get(user).size();t++){
                    if(wildAnimalHashmap.get(user).get(t).getName().equals("Bear")){
                        a=1;
                        wildAnimalHashmap.get(user).get(t).setCount(wildAnimalHashmap.get(user).get(t).getCount()+1);
                        Bear bear = new Bear();
                        wildAnimalHashmap.get(user).get(i).setTime(currentTime.getTime());
                        try {
                            wildAnimalHashmap.get(user).add(bear);
                        }
                        catch (NullPointerException n){
                            wildAnimalHashmap=new HashMap<>();
                            wildAnimalHashmap.get(user).add(bear);
                        }
                    }
                }if(a==0){
                    Bear bear = new Bear();
                    wildAnimalHashmap.get(user).get(i).setTime(currentTime.getTime());
                    bear.setCount(1);
                    try {
                        wildAnimalHashmap.get(user).add(bear);
                    }
                    catch (NullPointerException n){
                        wildAnimalHashmap=new HashMap<>();
                        wildAnimalHashmap.get(user).add(bear);
                    }
                }
                log.info("new Bear comes to field");
            } else if (i == 2) {
                int a=0;
                for(int t=0;t<wildAnimalHashmap.get(user).size();t++){
                    if(wildAnimalHashmap.get(user).get(t).getName().equals("Lion")){
                        a=1;
                        wildAnimalHashmap.get(user).get(t).setCount(wildAnimalHashmap.get(user).get(t).getCount()+1);
                        Lion lion = new Lion();
                        wildAnimalHashmap.get(user).get(i).setTime(currentTime.getTime());
                        try {
                            wildAnimalHashmap.get(user).add(lion);
                        }
                        catch (NullPointerException n){
                            wildAnimalHashmap=new HashMap<>();
                            wildAnimalHashmap.get(user).add(lion);
                        }
                    }
                }if(a==0){
                    Lion lion = new Lion();
                    wildAnimalHashmap.get(user).get(i).setTime(currentTime.getTime());
                    lion.setCount(1);
                    try {
                        wildAnimalHashmap.get(user).add(lion);
                    }
                    catch (NullPointerException n){
                        wildAnimalHashmap=new HashMap<>();
                        wildAnimalHashmap.get(user).add(lion);
                    }
                }
                log.info("new Lion comes to field");
            } else {
                int a=0;
                for(int t=0;t<wildAnimalHashmap.get(user).size();t++){
                    if(wildAnimalHashmap.get(user).get(t).getName().equals("Tiger")){
                        a=1;
                        wildAnimalHashmap.get(user).get(t).setCount(wildAnimalHashmap.get(user).get(t).getCount()+1);
                        Tiger tiger = new Tiger();
                        wildAnimalHashmap.get(user).get(i).setTime(currentTime.getTime());
                        try {
                            wildAnimalHashmap.get(user).add(tiger);
                        }
                        catch (NullPointerException n){
                            wildAnimalHashmap=new HashMap<>();
                            wildAnimalHashmap.get(user).add(tiger);
                        }
                    }
                }if(a==0){
                    Tiger tiger = new Tiger();
                    wildAnimalHashmap.get(user).get(i).setTime(currentTime.getTime());
                    tiger.setCount(1);
                    try {
                        wildAnimalHashmap.get(user).add(tiger);
                    }
                    catch (NullPointerException n){
                        wildAnimalHashmap=new HashMap<>();
                        wildAnimalHashmap.get(user).add(tiger);
                    }
                }
                log.info("new Tiger comes to field");
            }
        }
        logOut();
    }
    public void buildFactory(String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(factoryHashMap==null) factoryHashMap=new HashMap<>();
        if(factoryHashMap.get(user)==null) factoryHashMap.put(user,new ArrayList<>());
        if(name.equals("BreadFactory")){
            BreadFactory b=new BreadFactory();
            try {
                factoryHashMap.get(user).add(b);
            }
            catch (NullPointerException n){
                factoryHashMap=new HashMap<>();
                factoryHashMap.get(user).add(b);
            }
            log.info("build bread factory");
        }else if(name.equals("ClothFactory")){
            ClothFactory c=new ClothFactory();
            try {
                factoryHashMap.get(user).add(c);
            }
            catch (NullPointerException n){
                factoryHashMap=new HashMap<>();
                factoryHashMap.get(user).add(c);
            }
            log.info("build cloth factory");
        }else if(name.equals("FlourFactory")){
            FlourFactory f=new FlourFactory();
            try {
                factoryHashMap.get(user).add(f);
            }
            catch (NullPointerException n){
                factoryHashMap=new HashMap<>();
                factoryHashMap.get(user).add(f);
            }
            log.info("build flour factory");
        }else if(name.equals("IceCreamFactory")){
            IceCreamFactory i=new IceCreamFactory();
            try {
                factoryHashMap.get(user).add(i);
            }
            catch (NullPointerException n){
                factoryHashMap=new HashMap<>();
                factoryHashMap.get(user).add(i);
            }
            log.info("build icecream factory");
        }else if(name.equals("MilkPackagingFactory")){
            MilkPackagingFactory m=new MilkPackagingFactory();
            try {
                factoryHashMap.get(user).add(m);
            }
            catch (NullPointerException n){
                factoryHashMap=new HashMap<>();
                factoryHashMap.get(user).add(m);
            }
            log.info("build milk packaging factory");
        }else if(name.equals("ShirtFactory")){
            ShirtFactory s=new ShirtFactory();
            try {
                factoryHashMap.get(user).add(s);
            }
            catch (NullPointerException n){
                factoryHashMap=new HashMap<>();
                factoryHashMap.get(user).add(s);
            }
            log.info("build shirt factory");
        }else {
            System.out.println("Wrong Factory name!");
            log.error("wrong factory name for building");
        }
        logOut();
    }
    public void sendProductToWereHouse(String item){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        user.setLastEdit(dtf.format(now));
        if(productHashMap==null) productHashMap=new HashMap<>();
        if(productHashMap.get(user)==null) productHashMap.put(user,new ArrayList<>());
        if(wereHouseHashMap==null) wereHouseHashMap=new HashMap<>();
        int b=0;
        for(int i=0;i<productHashMap.get(user).size();i++){
            if(productHashMap.get(user).get(i).getName().equals(item)){
                b=1;
                if(wereHouseHashMap.get(user).getStorage()+productHashMap.get(user).get(i).getStorage()<=30){
                    int a=0;
                    productHashMap.get(user).get(i).setCount(productHashMap.get(user).get(i).getCount()-1);
                    for(int j=0;j<wereHouseHashMap.get(user).getProducts().size();j++){
                        if(wereHouseHashMap.get(user).getProducts().get(j).getName().equals(item)){
                            a=1;
                            wereHouseHashMap.get(user).getProducts().get(j).setCount(wereHouseHashMap.get(user).getProducts().get(j).getCount()+1);
                            break;
                        }
                    }if(a==0){
                        try {
                            wereHouseHashMap.get(user).getProducts().add(productHashMap.get(user).get(i));
                        }
                        catch (NullPointerException n){
                            wereHouseHashMap=new HashMap<>();
                            wereHouseHashMap.get(user).getProducts().add(productHashMap.get(user).get(i));
                        }
                    }
                    if(productHashMap.get(user).get(i).getCount()==0){
                        productHashMap.get(user).remove(i);
                    }
                    log.info("send product to werehouse");
                }else {
                    System.out.println("Not enough storage!");
                    log.error("werehouse is full, you can't send product");
                }
                break;
            }
        }
        if(b==0) {
            System.out.println("Wrong input!");
            log.error("wrong product name for sending to werehouse");
        }
        logOut();
    }
    public void dieDomesticAnimal(){
        if(domesticAnimalHashMap==null) domesticAnimalHashMap=new HashMap<>();
        if(domesticAnimalHashMap.get(user)==null) domesticAnimalHashMap.put(user,new ArrayList<>());
        for (int i = 0; i < domesticAnimalHashMap.get(user).size(); i++) {
            if (domesticAnimalHashMap.get(user).get(i).getHealth()==0){
                domesticAnimalHashMap.get(user).remove(i);
            }
        }
        logOut();
    }
    public void logOut(){
        Save save=new Save(domesticAnimalHashMap,factoryHashMap,grassHashMap,productHashMap,wellHashMap,vehicleHashMap,wereHouseHashMap,users,wildAnimalHashmap,dogHashMap,catHashMap);
        save.saveFile();
    }
}