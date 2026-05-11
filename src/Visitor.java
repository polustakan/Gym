import java.io.FileReader;
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
    public void dataReader (){
        FileReader fr = new FileReader(database.txt);

    }
}
