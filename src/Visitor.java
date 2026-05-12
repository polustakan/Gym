import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
}
