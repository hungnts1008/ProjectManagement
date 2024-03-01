package source.database;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import source.model.Staff;
import source.model.Project;
import source.model.Manager;

public class FileDB {

    private static FileDB instance;
    private ArrayList<Staff> ListOfStaff;
    private ArrayList<Project> ListOfProject;

    private FileDB() {
        ListOfStaff = new ArrayList<Staff>();
        ListOfProject = new ArrayList<Project>();

        String fileStaffName = "source//database//list_of_staff.txt";
        String fileProjectName = "source//database//list_of_project.txt";
        try {
            ListOfStaff.clear();
            FileReader reader = new FileReader(fileStaffName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] staffInfo = line.split(",");
                Staff staff = new Staff(staffInfo[0], staffInfo[1], staffInfo[2],
                        staffInfo[3], staffInfo[4],
                        staffInfo[5],
                        staffInfo[6], staffInfo[7], staffInfo[8]);
                ListOfStaff.add(staff);
            }

            ListOfProject.clear();
            reader = new FileReader(fileProjectName);
            bufferedReader = new BufferedReader(reader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] projectInfo = line.split(",");
                Project project = new Project(projectInfo[0], projectInfo[1], projectInfo[2],
                        java.sql.Date.valueOf(projectInfo[3]),
                        java.sql.Date.valueOf(projectInfo[4]), projectInfo[5], projectInfo[6]);
                ListOfProject.add(project);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FileDB getInstance() {
        if (instance == null) {
            instance = new FileDB();
        }
        return instance;
    }

    public ArrayList<Staff> getListOfStaff() {
        return ListOfStaff;
    }

    public ArrayList<Project> getListOfProject() {
        return ListOfProject;
    }

    public void writeStaffToFile() {
        String fileStaff = "source//database//list_of_staff.txt";
        try {
            FileWriter writer = new FileWriter(fileStaff);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Staff staff : ListOfStaff) {
                bufferedWriter.write(staff.toCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeProjectToFile() {
        String fileProject = "source//database//list_of_project.txt";
        try {
            FileWriter writer = new FileWriter(fileProject, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Project project : ListOfProject) {
                bufferedWriter.write(project.toCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * public static ArrayList<Staff> ListOfStaff = new ArrayList<Staff>();
     * public static ArrayList<Project> ListOfProject = new ArrayList<Project>();
     * 
     * public FileDB() {
     * String fileStaffName = "source//database//list_of_staff.txt";
     * String fileProjectName = "source//database//list_of_project.txt";
     * try {
     * ListOfStaff.clear();
     * FileReader reader = new FileReader(fileStaffName);
     * BufferedReader bufferedReader = new BufferedReader(reader);
     * String line;
     * while ((line = bufferedReader.readLine()) != null) {
     * String[] staffInfo = line.split(",");
     * Staff staff = new Staff(staffInfo[0], staffInfo[1], staffInfo[2],
     * staffInfo[3], staffInfo[4],
     * staffInfo[5],
     * staffInfo[6], staffInfo[7], staffInfo[8]);
     * ListOfStaff.add(staff);
     * }
     * 
     * ListOfProject.clear();
     * reader = new FileReader(fileProjectName);
     * bufferedReader = new BufferedReader(reader);
     * while ((line = bufferedReader.readLine()) != null) {
     * String[] projectInfo = line.split(",");
     * Project project = new Project(projectInfo[0], projectInfo[1], projectInfo[2],
     * java.sql.Date.valueOf(projectInfo[3]),
     * java.sql.Date.valueOf(projectInfo[4]), projectInfo[5], projectInfo[6]);
     * ListOfProject.add(project);
     * }
     * 
     * bufferedReader.close();
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * 
     * public static ArrayList<Staff> getListOfStaff() {
     * return ListOfStaff;
     * }
     * 
     * public static ArrayList<Project> getListOfProject() {
     * return ListOfProject;
     * }
     * 
     * public static void writeStaffToFile() {
     * String fileStaff = "source//database//list_of_staff.txt";
     * try {
     * FileWriter writer = new FileWriter(fileStaff);
     * BufferedWriter bufferedWriter = new BufferedWriter(writer);
     * for (Staff staff : ListOfStaff) {
     * bufferedWriter.write(staff.toCSV());
     * bufferedWriter.newLine();
     * }
     * bufferedWriter.close();
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * 
     * public void writeProjectToFile() {
     * String fileProject = "source//database//list_of_project.txt";
     * try {
     * FileWriter writer = new FileWriter(fileProject, false);
     * BufferedWriter bufferedWriter = new BufferedWriter(writer);
     * for (Project project : ListOfProject) {
     * bufferedWriter.write(project.toCSV());
     * bufferedWriter.newLine();
     * }
     * bufferedWriter.close();
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     */
}
