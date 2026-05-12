import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gym {
    private JPanel mainPanel;
    private JTextField nameField;
    private JComboBox <Integer> subscriptionDurationBox;
    private JList <String> databaseList;
    private JButton addButton;
    private JButton changeSubscriptionDurationButton;
    private JButton removeButton;
    private JButton changeNameButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gym");
        frame.setContentPane(new Gym().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(600,300);
        frame.setVisible(true);
        Scanner sc = new Scanner(System.in);
        System.out.println("nigga");
        Visitor v = new Visitor("Vladimir",sc.nextInt());
        v.date();
    }
    public class CustomDialogExample {
        public static void main(String[] args) {
            // 1. Create your custom button labels
            String[] options = {"Delete Anyway", "Keep Employee"};

            // 2. Use showOptionDialog to display them
            int choice = JOptionPane.showOptionDialog(
                    null,                       // Parent component
                    "Confirm to delete employee", // Message
                    "Are you sure?",             // Title
                    JOptionPane.YES_NO_OPTION,   // Option type
                    JOptionPane.QUESTION_MESSAGE, // Message type
                    null,                       // Custom icon (null uses default)
                    options,                    // The custom options array
                    options[1]                  // Initial value (default button)
            );

            // 3. Handle the user's click
            if (choice == 0) {
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
        }
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
            Scanner scFile = new Scanner(fr);
            while (scFile.hasNextLine()) {
                String[] parts = scFile.nextLine().split(",");

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
