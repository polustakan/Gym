import javax.swing.*;

public class Gym {
    private JPanel mainPanel;
    private JTextField nameField;
    private JComboBox subscriptionDurationBox;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gym");
        frame.setContentPane(new Gym().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,500);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        subscriptionDurationBox = new JComboBox<>();
        subscriptionDurationBox.addItem("");
        subscriptionDurationBox.addItem("1");
        subscriptionDurationBox.addItem("2");
        subscriptionDurationBox.addItem("3");
        subscriptionDurationBox.addItem("4");
        subscriptionDurationBox.addItem("5");
        subscriptionDurationBox.addItem("6");


        // TODO: place custom component creation code here
    }
}
