package source.model;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import source.dao.Dao;
import source.dao.ManagerDao;
import source.database.FileDB;

public class Manager extends Staff {
    private static FileDB fileDB = FileDB.getInstance();
    private static Dao<Manager> managerDao = new ManagerDao();
    private ArrayList<Project> projects;

    public Manager() {
        super();
        fileDB = FileDB.getInstance();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    /*********************************** */

    // add a new project to the list of projects

    public ArrayList<Staff> getStaffList() {
        return fileDB.getListOfStaff();
    }

    public static void addStaff(Staff staff) {
        fileDB.getListOfStaff().add(staff);
        fileDB.writeStaffToFile();
    }

    public void updateStaff(Staff staff) {
        for (int i = 0; i < fileDB.getListOfStaff().size(); i++) {
            if (fileDB.getListOfStaff().get(i).getStaffID().equals(staff.getStaffID())) {
                fileDB.getListOfStaff().set(i, staff);
                fileDB.writeStaffToFile();
                break;
            }
        }
    }

    public static void deleteStaff(String staffID) {
        for (int i = 0; i < fileDB.getListOfStaff().size(); i++) {
            if (fileDB.getListOfStaff().get(i).getStaffID().equals(staffID)) {
                fileDB.getListOfStaff().remove(i);
                fileDB.writeStaffToFile();
                break;
            }
        }
    }
}
