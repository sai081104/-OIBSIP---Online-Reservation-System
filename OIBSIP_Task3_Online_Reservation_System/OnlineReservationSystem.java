import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Reservation {
    String name, trainNumber, trainName, classType, date, from, to, pnr;

    public Reservation(String name, String trainNumber, String trainName, String classType, String date, String from, String to, String pnr) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.pnr = pnr;
    }
}

public class OnlineReservationSystem extends JFrame {
    private JTextField loginField, passField, nameField, trainNumberField, trainNameField, dateField, fromField, toField, pnrField;
    private JComboBox<String> classTypeBox;
    private JButton loginButton, reserveButton, cancelButton;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public OnlineReservationSystem() {
        setTitle("Online Reservation System");
        setSize(500, 400);
        setLayout(new CardLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Login");

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(loginField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(10, 2));

        nameField = new JTextField();
        trainNumberField = new JTextField();
        trainNameField = new JTextField();
        dateField = new JTextField();
        fromField = new JTextField();
        toField = new JTextField();
        pnrField = new JTextField();
        String[] classes = {"Sleeper", "AC", "First Class"};
        classTypeBox = new JComboBox<>(classes);
        reserveButton = new JButton("Reserve");
        cancelButton = new JButton("Cancel");

        mainPanel.add(new JLabel("Name:"));
        mainPanel.add(nameField);
        mainPanel.add(new JLabel("Train No:"));
        mainPanel.add(trainNumberField);
        mainPanel.add(new JLabel("Train Name:"));
        mainPanel.add(trainNameField);
        mainPanel.add(new JLabel("Class:"));
        mainPanel.add(classTypeBox);
        mainPanel.add(new JLabel("Date (dd/mm/yyyy):"));
        mainPanel.add(dateField);
        mainPanel.add(new JLabel("From:"));
        mainPanel.add(fromField);
        mainPanel.add(new JLabel("To:"));
        mainPanel.add(toField);
        mainPanel.add(new JLabel("PNR No (for cancellation):"));
        mainPanel.add(pnrField);
        mainPanel.add(reserveButton);
        mainPanel.add(cancelButton);

        add(loginPanel, "Login");
        add(mainPanel, "Main");

        loginButton.addActionListener(e -> {
            String username = loginField.getText();
            String password = passField.getText();
            if (username.equals("admin") && password.equals("123")) {
                ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "Main");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login!");
            }
        });

        reserveButton.addActionListener(e -> {
            String name = nameField.getText();
            String trainNumber = trainNumberField.getText();
            String trainName = trainNameField.getText();
            String classType = (String) classTypeBox.getSelectedItem();
            String date = dateField.getText();
            String from = fromField.getText();
            String to = toField.getText();
            String pnr = String.valueOf(System.currentTimeMillis()).substring(7);

            Reservation reservation = new Reservation(name, trainNumber, trainName, classType, date, from, to, pnr);
            reservations.add(reservation);
            JOptionPane.showMessageDialog(this, "Reservation Successful!\nPNR No: " + pnr);
        });

        cancelButton.addActionListener(e -> {
            String pnr = pnrField.getText();
            boolean found = false;
            for (Reservation res : reservations) {
                if (res.pnr.equals(pnr)) {
                    reservations.remove(res);
                    JOptionPane.showMessageDialog(this, "Reservation Cancelled Successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "PNR not found!");
            }
        });
    }

    public static void main(String[] args) {
        OnlineReservationSystem ors = new OnlineReservationSystem();
        ors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ors.setVisible(true);
    }
}
