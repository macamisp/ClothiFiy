package controller.admin;

import entity.Admin;
import javafx.collections.ObservableList;

public interface AdminService1 {
    boolean addAdmin(Admin admin);
    boolean deleteAdmin(String id);
    ObservableList<Admin> getAll();
    boolean updateAdmin(Admin admin);
    Admin searchAdmin(String id);
    ObservableList<String> getAdminIds();
}