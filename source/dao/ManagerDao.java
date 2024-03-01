package source.dao;

import java.util.ArrayList;
import java.util.Optional;

import source.model.Manager;

public class ManagerDao implements Dao<Manager> {
    private static ManagerDao instance;
    private ArrayList<Manager> managers = new ArrayList<Manager>();

    public ManagerDao() {
    }

    public static ManagerDao getInstance() {
        if (instance == null) {
            instance = new ManagerDao();
        }
        return instance;
    }

    @Override
    public ArrayList<Manager> getAll() {
        return managers;
    }

    @Override
    public Optional<Manager> get(String id) {
        for (Manager manager : managers) {
            if (manager.getStaffID().equals(id)) {
                return Optional.of(manager);
            }
        }
        return null;
    }

    @Override
    public void save(Manager manager) {
        managers.add(manager);
    }

    @Override
    public void update(Manager manager) {
        for (int i = 0; i < managers.size(); i++) {
            if (managers.get(i).getStaffID().equals(manager.getStaffID())) {
                managers.set(i, manager);
                return;
            }
        }
    }

    @Override
    public void delete(Manager manager) {
        for (int i = 0; i < managers.size(); i++) {
            if (managers.get(i).getStaffID().equals(manager.getStaffID())) {
                managers.remove(i);
                return;
            }
        }
    }
}
