package source.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameProject extends JFrame {
    private JPanel panel;
    private JButton buttonAddTask, buttonDelTask, buttonLogOut, buttonProjectView;

    public FrameProject(String user) {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Manager: " + user);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {
        buttonAddTask = new JButton("Add Task");
        buttonDelTask = new JButton("Delete Task");
        buttonLogOut = new JButton("Log Out");
        buttonProjectView = new JButton(" View Project:");
        panel = new JPanel(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;

        panel.add(buttonAddTask, constraints);
        panel.add(buttonDelTask, constraints);
        panel.add(buttonLogOut, constraints);
        panel.add(buttonProjectView, constraints);

        add(panel, BorderLayout.NORTH);
        setSize(1920, 1080);
        setVisible(true);
    }
}
