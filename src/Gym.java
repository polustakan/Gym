import javax.swing.*;
import java.util.Scanner;

public class Gym {
    private JPanel mainPanel;
    private JTextField nameField;
    private JComboBox subscriptionDurationBox;
    private JList databaseList;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gym");
        frame.setContentPane(new Gym().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,500);
        frame.setVisible(true);
        Scanner sc = new Scanner(System.in);
        System.out.println("nigga");
        Visitor v = new Visitor("Vladimir",sc.nextInt());
        v.date();
    }

    private void createUIComponents() {
        subscriptionDurationBox = new JComboBox<>();
        subscriptionDurationBox.addItem("1");
        subscriptionDurationBox.addItem("2");
        subscriptionDurationBox.addItem("3");
        subscriptionDurationBox.addItem("4");
        subscriptionDurationBox.addItem("5");
        subscriptionDurationBox.addItem("6");
        subscriptionDurationBox.addItem("7");
        subscriptionDurationBox.addItem("8");
        subscriptionDurationBox.addItem("9");
        subscriptionDurationBox.addItem("10");
        subscriptionDurationBox.addItem("11");
        subscriptionDurationBox.addItem("12");
    }
}
