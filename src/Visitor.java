import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Visitor {
    private String name;
    private int months;
    Visitor(String name, int months){
        this.name = name;
        this.months = months;
    }
    public void date (){
        LocalDate now = LocalDate.now();
        LocalDate end = now.plusMonths(months);
        System.out.println(end);
    }
    public  void dataWriter(){
        try {
            FileWriter fw = new FileWriter("database.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void dataReader (){
        try {
            FileReader fr = new FileReader("database.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
