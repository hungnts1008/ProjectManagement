package source.view;

import source.controller.LogInManagement;
import source.controller.ManagerManagement;
import source.controller.ProjectManagement;

import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameManager extends JFrame {
    private JButton buttonAddStaff, buttonDelStaff, buttonLogOut, buttonProjectView;
    private JPanel panel;
    private DefaultTableModel model;

    public FrameManager(String user) {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Manager: " + user);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        buttonAddStaff = new JButton("Add Staff");
        buttonDelStaff = new JButton("Delete Staff");
        buttonLogOut = new JButton("Log Out");
        // maybe have a "edit staff button"
        buttonProjectView = new JButton(" View Project:");
        panel = new JPanel(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;

        panel.add(buttonAddStaff, constraints);
        panel.add(buttonDelStaff, constraints);
        panel.add(buttonLogOut, constraints);
        panel.add(buttonProjectView, constraints);

        JTable staffTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(staffTable);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        setSize(1920, 1080);
        setVisible(true);

        buttonAddStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerManagement.displayAddStaffWindow(model);
            }
        });

        buttonDelStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerManagement.displayDeleteStaffWindow(model);
            }
        });

        buttonLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogInManagement logInManagement = new LogInManagement();
                logInManagement.logOut();
                dispose();
            }
        });

        buttonProjectView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ManagerManagement.displayProjectViewWindow();
                ProjectManagement projectManagement = new ProjectManagement();
            }
        });
    }

    // getters and setters
    public JButton getbuttonAddStaff() {
        return buttonAddStaff;
    }

    public void setbuttonAddStaff(JButton buttonAddStaff) {
        this.buttonAddStaff = buttonAddStaff;
    }

    public JButton getButtonDelStaff() {
        return buttonDelStaff;
    }

    public void setButtonDelStaff(JButton buttonDelStaff) {
        this.buttonDelStaff = buttonDelStaff;
    }

    public JButton getbuttonLogOut() {
        return buttonLogOut;
    }

    public void setbuttonLogOut(JButton buttonLogOut) {
        this.buttonLogOut = buttonLogOut;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

}
