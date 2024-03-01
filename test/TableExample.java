import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class TableExample {
    private static ArrayList<Object[]> data = new ArrayList<Object[]>();

    public static void displayFormWindow(DefaultTableModel model) {
        JFrame addStaffFrame = new JFrame("Window for Adding Staff");
        addStaffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField idField = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField roleField = new JTextField(20);
        JTextField userNameField = new JTextField(20);
        JTextField passWordField = new JTextField(20);
        JTextField statusField = new JTextField(20);
        ArrayList<JTextField> textFields = new ArrayList<JTextField>();

        textFields.add(idField);
        textFields.add(nameField);
        textFields.add(phoneField);
        textFields.add(emailField);
        textFields.add(addressField);
        textFields.add(roleField);
        textFields.add(userNameField);
        textFields.add(passWordField);
        textFields.add(statusField);

        JLabel idLabel = new JLabel("ID: ");
        JLabel nameLabel = new JLabel("Name: ");
        JLabel phoneLabel = new JLabel("Phone: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel addressLabel = new JLabel("Address: ");
        JLabel roleLabel = new JLabel("Role: ");
        JLabel userNameLabel = new JLabel("UserName: ");
        JLabel passWordLabel = new JLabel("PassWord: ");
        JLabel statusLabel = new JLabel("Status: ");

        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        labels.add(idLabel);
        labels.add(nameLabel);
        labels.add(phoneLabel);
        labels.add(emailLabel);
        labels.add(addressLabel);
        labels.add(roleLabel);
        labels.add(userNameLabel);
        labels.add(passWordLabel);
        labels.add(statusLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] obj = { textFields.get(0).getText(), textFields.get(1).getText(),
                        textFields.get(2).getText(), textFields.get(3).getText(), textFields.get(4).getText(),
                        textFields.get(5).getText(), textFields.get(6).getText(), textFields.get(7).getText(),
                        textFields.get(8).getText() };
                model.addRow(obj);

                addStaffFrame.dispose();
            }
        });

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        panel.add(labels.get(0));
        panel.add(textFields.get(0));
        layout.putConstraint(SpringLayout.WEST, labels.get(0), 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labels.get(0), 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textFields.get(0), 5 + labels.get(0).getText().length(),
                SpringLayout.EAST, labels.get(0));
        layout.putConstraint(SpringLayout.NORTH, textFields.get(0), 5, SpringLayout.NORTH, panel);

        for (int i = 1; i < labels.size(); i++) {
            panel.add(labels.get(i));
            panel.add(textFields.get(i));

            layout.putConstraint(SpringLayout.WEST, labels.get(i), 5, SpringLayout.WEST, panel);

            layout.putConstraint(SpringLayout.NORTH, labels.get(i), 10, SpringLayout.SOUTH, labels.get(i - 1));

            layout.putConstraint(SpringLayout.WEST, textFields.get(i), 5 + labels.get(i).getText().length(),
                    SpringLayout.EAST, labels.get(i));

            layout.putConstraint(SpringLayout.NORTH, textFields.get(i), 6, SpringLayout.SOUTH, textFields.get(i - 1));
        }

        panel.add(submitButton);
        layout.putConstraint(SpringLayout.WEST, submitButton, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.SOUTH, labels.get(labels.size() - 1));

        addStaffFrame.add(panel);
        addStaffFrame.pack();
        addStaffFrame.setSize(1920, 1080);
        addStaffFrame.setVisible(true);
    }

    public static void displayDeleteWindow(DefaultTableModel model) {
        JFrame deleteStaffFrame = new JFrame("Window for Deleting Staff");
        deleteStaffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField idField = new JTextField(20);
        JLabel idLabel = new JLabel("ID: ");
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = Integer.parseInt(idField.getText());
                model.removeRow(row);
                deleteStaffFrame.dispose();
            }
        });

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        panel.add(idLabel);
        panel.add(idField);
        layout.putConstraint(SpringLayout.WEST, idLabel, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idField, 5 + idLabel.getText().length(), SpringLayout.EAST, idLabel);
        layout.putConstraint(SpringLayout.NORTH, idField, 5, SpringLayout.NORTH, panel);

        panel.add(submitButton);
        layout.putConstraint(SpringLayout.WEST, submitButton, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.SOUTH, idLabel);

        deleteStaffFrame.add(panel);
        deleteStaffFrame.pack();
        deleteStaffFrame.setSize(1920, 1080);
        deleteStaffFrame.setVisible(true);
    }

    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel();

        JFrame frame = new JFrame("Staff Information Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Add Staff");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFormWindow(model);
            }
        });

        JButton button2 = new JButton("Delete Staff");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayDeleteWindow(model);
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(button1, constraints);
        panel.add(button2, constraints);

        // Create table data
        data.add(new Object[] { 1, "John Doe", "123-456-7890", "johndoe@gmail.com", "Yen Nghia, Ha Dong, Hanoi",
                "Manager",
                "john.doe", "password", "Active" });

        // Create table column names
        String[] columnNames = { "ID", "Name", "Phone", "Email", "Address", "Role",
                "UserName", "PassWord", "Status" };

        // Create a table model
        for (String columnName : columnNames) {
            model.addColumn(columnName);
        }
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Set frame size and make it visible
        frame.setSize(1920, 1080);
        // frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
