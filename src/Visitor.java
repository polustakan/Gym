import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Visitor {
    private String name;
    private int months;
    private LocalDate start;
    Visitor(String name, int months){
        this.name = name;
        this.months = months;
        this.start = LocalDate.now();
    }
    Visitor(String name, int months,LocalDate start){
        this.name = name;
        this.months = months;
        this.start = start;
    }
    Visitor(){}

    public boolean dateFormatter(){
        LocalDate end = start.plusMonths(months);
        Period period = Period.between(LocalDate.now(), end);
        if (period.isNegative()||period.isZero()){
            return true;}
        else return false;
    }

    public void date (){
        LocalDate end = start.plusMonths(months);
        Period period = Period.between(LocalDate.now(), end);
        if (period.isNegative()||period.isZero()){
            JOptionPane.showMessageDialog(null,"The "+name+"'s subscription has been ended. \n Delete it please!!!","Ended subscription",JOptionPane.ERROR_MESSAGE);
        } else {
        int confirm = JOptionPane.showConfirmDialog(null,"The "+name+"'s subscription ends at "+end+"\nDo you want know how much time until subscription ends?","Ending time",JOptionPane.YES_NO_OPTION);
        if (confirm!=JOptionPane.YES_OPTION)return;
        JOptionPane.showMessageDialog(null,"The "+name+"'s subscription ends after "+period.getMonths()+" months and "+period.getDays()+" days.");
        }
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getMonths() {return months;}

    public void setMonths(int months) {this.months = months;}

    public LocalDate getStart() {return start;}

    public void setStart(LocalDate start) {this.start = start;}

    @Override
    public String toString() {return name+"," + months+","+start;}
}
