package source.model;

import java.sql.Date;
import java.util.ArrayList;

public class Project {
    private String ID;
    private String Name;
    private String Description;
    private Date StartDate;
    private Date EndDate;
    private String ManagerID;
    private String Status; // Done, In Progress, Archived
    private ArrayList<Staff> participatedStaff;

    public Project() {
        ID = "";
        Name = "";
        Description = "";
        StartDate = null;
        EndDate = null;
        ManagerID = null;
        Status = "";
        participatedStaff = new ArrayList<Staff>();
    }

    // Staff->String managementID

    public Project(String ID, String Name, String Description, Date StartDate, Date EndDate, String ManagerID,
            String Status) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.ManagerID = ManagerID;
        this.Status = Status;
        participatedStaff = new ArrayList<Staff>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getManagerID() {
        return ManagerID;
    }

    public void setManagerID(String ManagerID) {
        this.ManagerID = ManagerID;
    }

    public String isStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public ArrayList<Staff> getParticipatedStaff() {
        return participatedStaff;
    }

    public void setParticipatedStaff(ArrayList<Staff> participatedStaff) {
        this.participatedStaff = participatedStaff;
    }

    public void addStaffToProject(Staff staff) {
        participatedStaff.add(staff);
    }

    public void removeStaffFromProject(Staff staff) {
        participatedStaff.remove(staff);
    }

    public String toString() {
        return "Project ID: " + ID + "\nProject Name: " + Name + "\nProject Description: " + Description
                + "\nProject Start Date: " + StartDate + "\nProject End Date: " + EndDate + "\nProject Manager ID: "
                + ManagerID + "\nProject Status: " + Status;
    }

    public String toCSV() {
        return ID + "," + Name + "," + Description + "," + StartDate + "," + EndDate + "," + ManagerID + "," + Status;
    }
}
