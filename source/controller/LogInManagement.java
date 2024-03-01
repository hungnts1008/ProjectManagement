package source.controller;

import java.util.ArrayList;

import source.model.Manager;
import source.model.Staff;
import source.view.FrameLogIn;
import source.view.FrameManager;

public class LogInManagement {
    Manager manager;
    ArrayList<Staff> ListOfStaff;

    public static boolean isManager = false;
    public static boolean isStaff = false;

    public LogInManagement() {
        manager = new Manager();
        ListOfStaff = manager.getStaffList();
    }

    public int logIn(String userName, String passWord) {
        // System.out.println("FileDB.ListOfStaff.size() = " + ListOfStaff.size());
        for (Staff staff : ListOfStaff) {
            if (staff.getStaffUsername().equals(userName) && staff.getStaffPassword().equals(passWord)) {
                if (staff.getStaffRole().equals("Manager")) {
                    // System.out.println("Manager");
                    isManager = true;
                    isStaff = false;
                    return 1;
                } else {
                    // System.out.println("Staff");
                    isStaff = true;
                    isManager = false;
                    return 2;
                }
            }
        }
        return 0;
    }

    public void LogIn(int type, String user) {
        System.out.println("Log in successfully");
        if (type == 1) {
            // FrameManager frameManager = new FrameManager(user);
            // frameManager.setVisible(true);
            ManagerManagement managerManagement = new ManagerManagement(user);
        } /*
           * else {
           * FrameStaff frameStaff = new FrameStaff(user);
           * frameStaff.setVisible(true);
           * }
           */
    }

    public void logOut() {
        isManager = false;
        isStaff = false;
        FrameLogIn frameLogIn = new FrameLogIn();
        frameLogIn.setVisible(true);
    }
}
