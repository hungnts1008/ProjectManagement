package source.controller;

import source.view.FrameManager;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import source.database.FileDB;
import source.model.Staff;
import source.model.Manager;

public class ManagerManagement {
    private FrameManager frameManager;
    private static FileDB fileDB = FileDB.getInstance();

    public ManagerManagement(String user) {
        fileDB = FileDB.getInstance();
        frameManager = new FrameManager(user);
        String[] columnNames = { "ID", "Name", "Phone", "Email", "Address", "Role",
                "UserName", "PassWord", "Status" };

        for (String columnName : columnNames) {
            frameManager.getModel().addColumn(columnName);
        }

        for (Staff staff : fileDB.getListOfStaff()) {
            frameManager.getModel().addRow(new Object[] { staff.getStaffID(), staff.getStaffName(),
                    staff.getStaffPhone(),
                    staff.getStaffEmail(),
                    staff.getStaffAddress(), staff.getStaffRole(), staff.getStaffUsername(),
                    staff.getStaffPassword(),
                    staff.getStaffStatus() });
        }
    }

    public static void displayAddStaffWindow(DefaultTableModel model) {
        JFrame frame = new JFrame("Add Staff");
        ArrayList<JTextField> textFields = new ArrayList<JTextField>();
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        String[] labelNames = { "ID", "Name", "Phone", "Email", "Address", "Role",
                "Username", "Password", "Status" };
        for (String labelName : labelNames) {
            labels.add(new JLabel(labelName + ":"));
        }

        for (int i = 0; i < labelNames.length; i++) {
            textFields.add(new JTextField(27 - labelNames[i].length()));
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] staffInfo = new String[9];
                for (int i = 0; i < labelNames.length; i++) {
                    staffInfo[i] = textFields.get(i).getText();
                }
                Staff staff = new Staff(staffInfo[0], staffInfo[1], staffInfo[2],
                        staffInfo[3], staffInfo[4],
                        staffInfo[5],
                        staffInfo[6], staffInfo[7], staffInfo[8]);
                Manager.addStaff(staff);

                model.addRow(new Object[] { staff.getStaffID(), staff.getStaffName(),
                        staff.getStaffPhone(),
                        staff.getStaffEmail(), staff.getStaffAddress(), staff.getStaffRole(),
                        staff.getStaffUsername(),
                        staff.getStaffPassword(), staff.getStaffStatus() });
                frame.dispose();
            }
        });

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        panel.add(labels.get(0));
        panel.add(textFields.get(0));
        layout.putConstraint(SpringLayout.WEST, labels.get(0), 5, SpringLayout.WEST,
                panel);
        layout.putConstraint(SpringLayout.NORTH, labels.get(0), 5,
                SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textFields.get(0), 5 +
                labels.get(0).getText().length(),
                SpringLayout.EAST, labels.get(0));
        layout.putConstraint(SpringLayout.NORTH, textFields.get(0), 5,
                SpringLayout.NORTH, panel);

        for (int i = 1; i < labels.size(); i++) {
            panel.add(labels.get(i));
            panel.add(textFields.get(i));

            layout.putConstraint(SpringLayout.WEST, labels.get(i), 5, SpringLayout.WEST,
                    panel);

            layout.putConstraint(SpringLayout.NORTH, labels.get(i), 10,
                    SpringLayout.SOUTH, labels.get(i - 1));

            layout.putConstraint(SpringLayout.WEST, textFields.get(i), 5 +
                    labels.get(i).getText().length(),
                    SpringLayout.EAST, labels.get(i));

            layout.putConstraint(SpringLayout.NORTH, textFields.get(i), 6,
                    SpringLayout.SOUTH, textFields.get(i - 1));
        }

        panel.add(submitButton);
        layout.putConstraint(SpringLayout.WEST, submitButton, 5, SpringLayout.WEST,
                panel);
        layout.putConstraint(SpringLayout.NORTH, submitButton, 10,
                SpringLayout.SOUTH, labels.get(labels.size() - 1));

        frame.add(panel);
        frame.pack();

        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void displayDeleteStaffWindow(DefaultTableModel model) {
        JFrame deleteStaffFrame = new JFrame("Window for Deleting Staff");
        // deleteStaffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField idField = new JTextField(20);
        JLabel idLabel = new JLabel("ID: ");
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String StaffID = idField.getText();
                int row = -1;
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(StaffID)) {
                        row = i;
                        break;
                    }
                }
                model.removeRow(row);
                Manager.deleteStaff(StaffID);
                deleteStaffFrame.dispose();// close the window and
            }
        });

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        panel.add(idLabel);
        panel.add(idField);
        layout.putConstraint(SpringLayout.WEST, idLabel, 5, SpringLayout.WEST,
                panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 5, SpringLayout.NORTH,
                panel);
        layout.putConstraint(SpringLayout.WEST, idField, 5 +
                idLabel.getText().length(), SpringLayout.EAST, idLabel);
        layout.putConstraint(SpringLayout.NORTH, idField, 5, SpringLayout.NORTH,
                panel);

        panel.add(submitButton);
        layout.putConstraint(SpringLayout.WEST, submitButton, 5, SpringLayout.WEST,
                panel);
        layout.putConstraint(SpringLayout.NORTH, submitButton, 10,
                SpringLayout.SOUTH, idLabel);

        deleteStaffFrame.add(panel);
        deleteStaffFrame.pack();
        deleteStaffFrame.setSize(300, 300);
        deleteStaffFrame.setLocationRelativeTo(null);
        deleteStaffFrame.setVisible(true);
    }
}
