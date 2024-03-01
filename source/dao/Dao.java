package source.dao;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao<T> {
    ArrayList<T> getAll();

    ArrayList<T> get(String id); // null or object

    void save(T t);

    void update(T t);

    void delete(T t);
}
