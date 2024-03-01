package source.model;

import java.util.ArrayList;

import source.dao.ProjectDao;
import source.dao.StaffDao;

public class Staff {
    private static ProjectDao projectDao = ProjectDao.getInstance();

    private String staffID;
    private String staffName;
    private String staffPhone;
    private String staffEmail;
    private String staffAddress;
    private String staffRole;
    private String staffUsername;
    private String staffPassword;
    private String staffStatus;
    private ArrayList<Project> ParticipatingProjects;

    public Staff() {
        staffID = "";
        staffName = "";
        staffPhone = "";
        staffEmail = "";
        staffAddress = "";
        staffRole = "";
        staffUsername = "";
        staffPassword = "";
        staffStatus = "";
        ParticipatingProjects = projectDao.getAll();
    }

    public Staff(String staffID, String staffName, String staffPhone, String staffEmail, String staffAddress,
            String staffRole,
            String staffUsername, String staffPassword, String staffStatus) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
        this.staffRole = staffRole;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.staffStatus = staffStatus;
        this.ParticipatingProjects = projectDao.get(staffID);
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public ArrayList<Project> getParticipatingProjects() {
        return ParticipatingProjects;
    }

    public void setParticipatingProjects(ArrayList<Project> ParticipatingProjects) {
        this.ParticipatingProjects = ParticipatingProjects;
    }

    public String toString() {
        return "Staff ID: " + staffID + "\nStaff Name: " + staffName + "\nStaff Phone: " + staffPhone
                + "\nStaff Email: "
                + staffEmail + "\nStaff Address: " + staffAddress + "\nStaff Role: " + staffRole + "\nStaff Username: "
                + staffUsername + "\nStaff Password: " + staffPassword + "\nStaff Status: " + staffStatus;
    }

    public String toCSV() {
        return staffID + "," + staffName + "," + staffPhone + "," + staffEmail + "," + staffAddress + "," + staffRole
                + "," + staffUsername + "," + staffPassword + "," + staffStatus;
    }

}
