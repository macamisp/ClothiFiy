package repository;

import javafx.collections.ObservableList;

public interface CrudDao<T> extends SuperDAO{
    boolean save(T t);
    boolean update(T t);
    boolean delete(String id);
    ObservableList<T> findAll();
    T findById(String id);
}
