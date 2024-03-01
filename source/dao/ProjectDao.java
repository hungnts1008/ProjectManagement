package source.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

import source.model.Project;

public class ProjectDao implements Dao<Project> {
    private static ProjectDao instance;
    private ArrayList<Project> projects = new ArrayList<Project>();

    public ProjectDao() {
    }

    public static ProjectDao getInstance() {
        if (instance == null) {
            instance = new ProjectDao();
        }
        return instance;
    }

    @Override
    public ArrayList<Project> getAll() {
        return projects;
    }

    /*
     * @Override
     * public Optional<Project> get(String id) {
     * for (Project project : projects) {
     * if (project.getID().equals(id)) {
     * return Optional.of(project);
     * }
     * }
     * return null;
     * }
     */

    @Override
    public ArrayList<Project> get(String id) {// find projects by staff id
        ArrayList<Project> res = new ArrayList<Project>();
        for (Project project : projects) {
            for (int i = 0; i < project.getParticipatedStaff().size(); i++) {
                if (project.getParticipatedStaff().get(i).getStaffID().equals(id)) {
                    res.add(project);
                }
            }
        }
        return res;
    }

    @Override
    public void save(Project project) {
        projects.add(project);
    }

    @Override
    public void update(Project project) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getID().equals(project.getID())) {
                projects.set(i, project);
                return;
            }
        }
    }

    @Override
    public void delete(Project project) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getID().equals(project.getID())) {
                projects.remove(i);
                return;
            }
        }
    }
}
