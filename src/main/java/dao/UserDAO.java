package dao;

import entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers() throws SQLException;

    public boolean addUser(User user);

    public void createTable();

    public boolean delete(Long id);

    public boolean editUser(User user, String newName, String newPassword);

    public boolean validateUser(User user);

    public User getUserById(Long id);
}
