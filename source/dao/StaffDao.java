package source.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import source.model.Staff;

public class StaffDao implements Dao<Staff> {
    private static StaffDao instance;
    private List<Staff> staffs = new ArrayList<>();

    public StaffDao() {
    }

    public static StaffDao getInstance() {
        if (instance == null) {
            instance = new StaffDao();
        }
        return instance;
    }

    @Override
    public ArrayList<Staff> getAll() {
        return staffs;
    }

    /*
     * public Optional<Staff> get(String id) {
     * for (Staff staff : staffs) {
     * if (staff.getStaffID().equals(id)) {
     * return Optional.of(staff);
     * }
     * }
     * return null;
     * }
     */

    @Override
    public ArrayList<Staff> get(String id) {
        ArrayList<Staff> res = new ArrayList<Staff>();
        for (Staff staff : staffs) {
            if (staff.getStaffID().equals(id)) {
                res.add(staff);
            }
        }
        return res;
    }

    @Override
    public void save(Staff staff) {
        staffs.add(staff);
    }

    @Override
    public void update(Staff staff) {
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getStaffID().equals(staff.getStaffID())) {
                staffs.set(i, staff);
                return;
            }
        }
    }

    @Override
    public void delete(Staff staff) {
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getStaffID().equals(staff.getStaffID())) {
                staffs.remove(i);
                return;
            }
        }
    }
}
