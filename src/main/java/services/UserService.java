package services;

import dao.UserHibernateDAO;
import entities.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

//import dao.UserJdbcDAO;

public class UserService {

    private SessionFactory sessionFactory;

    private static UserService userService;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public List<User> getAllUsers() {
        return new UserHibernateDAO(sessionFactory).getAllUsers();
    }

    public boolean addUser(User user) {
        return new UserHibernateDAO(sessionFactory).addUser(user);
    }

    public void createTable() {
        new UserHibernateDAO(sessionFactory).createTable();
    }

    public boolean delete(Long id) {
        return new UserHibernateDAO(sessionFactory).delete(id);
    }

    public boolean editUser(User user, String newName, String newPassword) {
        return new UserHibernateDAO(sessionFactory).editUser(user, newName, newPassword);
    }

    public User getUserById(Long id) {
        return new UserHibernateDAO(sessionFactory).getUserById(id);
    }


}
