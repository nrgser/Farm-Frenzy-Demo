import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInformation{
    private String userName;
    private int levels;
    private int password;
    private int coins;
    private String addDate;
    private String lastEdit;


    public UserInformation(String userName, int password) {
        this.userName = userName;
        this.password = password;
        this.levels = 1;
        this.coins = 200;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.addDate=dtf.format(now);
    }
    public String getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(String lastEdit) {
        this.lastEdit = lastEdit;
    }

    public String getAddDate() {
        return addDate;
    }

    public int getCoins() { return coins; }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
   /* public UserInformation(String userName,int password){
        this.setUserName(userName);
        this.setPassword(password);
    }*/
}
