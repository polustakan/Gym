import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gym {
    private JPanel mainPanel;
    private JTextField nameField;
    private JComboBox <Integer> subscriptionDurationBox;
    private JList <String> databaseList;
    private JButton addButton;
    private JButton removeButton;
    private JButton editButton;
    private JButton clearButton;
    private JButton endDateButton;
    private DefaultListModel <String> model = new DefaultListModel<>();
    private ArrayList <Visitor> visitors = new ArrayList<>();
    private Object [] choise = {"Change name","Change subscription duration","Cancel"};

    public Gym(){
        databaseList.setModel(model);
        dataReader();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty()){
                    error();
                }else {
                    Visitor visitor = new Visitor(nameField.getText(),(Integer) subscriptionDurationBox.getSelectedItem());
                    if (confirmation()== JOptionPane.NO_OPTION) return;
                    visitors.add(visitor);
                    nameField.setText("");
                    subscriptionDurationBox.setSelectedItem(1);
                    modelList();
                    dataWriter();
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (confirmation()==JOptionPane.NO_OPTION)return;
                visitors.clear();
                model.clear();
                dataClean();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index()==-1){
                    return;
                }
                if (confirmation()==JOptionPane.NO_OPTION)return;
                visitors.remove(index());
                modelList();
                dataWriter();
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index()==-1){
                    return;
                }
                int confirmation = JOptionPane.showOptionDialog(null, "Choose one of the variant", "choosing", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choise, choise[2]);
                if (confirmation==2)return;
                Visitor visitor = visitors.get(index());
                if (confirmation==0){
                    String newName = JOptionPane.showInputDialog("Enter new name", visitor.getName());
                    if (newName != null && !newName.isEmpty())visitor.setName(newName);
                    modelList();
                    dataWriter();
                }else {
                    try {
                        int newDuration = Integer.parseInt(JOptionPane.showInputDialog("Input new subscription duration", visitor.getMonths()));
                        if (newDuration>0)visitor.setMonths(newDuration);
                        modelList();
                        dataWriter();
                    } catch (NumberFormatException ex) {
                        error();
                    }
                }
            }
        });
        endDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index()==-1){
                    return;
                }
                Visitor visitor = visitors.get(index());
                visitor.date();
            }
        });

    }
    public void modelList(){
        model.clear();
        for (Visitor visitor:visitors) {
            model.addElement(visitor.toString());
        }
    }

    public int index (){
        if (databaseList.getSelectedIndex()>-1){
            return databaseList.getSelectedIndex();
        }else {
            error();
            return -1;
        }
    }

    public int confirmation(){return JOptionPane.showConfirmDialog(null,"Are you sure?","Confirmation",JOptionPane.YES_NO_OPTION);}

    public void error(){JOptionPane.showMessageDialog(null,"Invalid input","Error",JOptionPane.ERROR_MESSAGE);}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gym");
        frame.setContentPane(new Gym().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(600,300);
        frame.setVisible(true);
    }
    public void dataClean(){
        try {
            FileWriter fw = new FileWriter("database.txt");
            fw.write("");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void dataWriter(){
        try {
            FileWriter fw = new FileWriter("database.txt");
            for (Visitor visitor:visitors){
                fw.write(visitor.toString()+"\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void dataReader (){
        try {
            FileReader fr = new FileReader("database.txt");
            Scanner scFile = new Scanner(fr);
            while (scFile.hasNextLine()) {
                String[] parts = scFile.nextLine().split(",");
                Visitor visitor = new Visitor(parts[0],Integer.parseInt(parts[1]));
                visitors.add(visitor);
                modelList();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void createUIComponents() {
        subscriptionDurationBox = new JComboBox<>();
        subscriptionDurationBox.addItem(1);
        subscriptionDurationBox.addItem(2);
        subscriptionDurationBox.addItem(3);
        subscriptionDurationBox.addItem(4);
        subscriptionDurationBox.addItem(5);
        subscriptionDurationBox.addItem(6);
        subscriptionDurationBox.addItem(7);
        subscriptionDurationBox.addItem(8);
        subscriptionDurationBox.addItem(9);
        subscriptionDurationBox.addItem(10);
        subscriptionDurationBox.addItem(11);
        subscriptionDurationBox.addItem(12);
    }
}
