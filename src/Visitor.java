import javax.swing.*;
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
        JOptionPane.showMessageDialog(null,"The "+name+"'s subscripion ends at "+end);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getMonths() {return months;}

    public void setMonths(int months) {this.months = months;}

    @Override
    public String toString() {return name+"," + months;
    }
}
