package repository;

import dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface CrudDao<T> extends SuperDAO{
    boolean save(T t);
    ObservableList<T> getAll();
    boolean delete(String id);
    T search(String id);
    boolean update(T t);
}
