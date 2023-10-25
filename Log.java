import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    File file = new File("log.txt");
    FileWriter fr = null;
    public void header(String addFile,String name,String lastEdit){
        String str=""+addFile+" "+name+" "+lastEdit;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter br = new BufferedWriter(fr);
        try {
            br.write(str+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void error(String error){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String str="[Error], "+dtf.format(now)+", "+error;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter br = new BufferedWriter(fr);
        try {
            br.write(str+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void info(String info){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String str="[Info], "+dtf.format(now)+", "+info;;
        try {
            fr = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter br = new BufferedWriter(fr);
        try {
            br.write(str+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
