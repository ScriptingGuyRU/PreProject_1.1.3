package util;


//import dao.UserJdbcDAO;
import entities.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static SessionFactory sessionFactory;
//
//    private static Connection getMysqlConnection() {
//        try {
//            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
//
//            StringBuilder url = new StringBuilder();
//
//            url.
//                    append("jdbc:mysql://").        //db type
//                    append("localhost:").           //host name
//                    append("3306/").                //port
//                    append("pre_project_crud?").    //db name
//                    append("user=root&").          //login
//                    append("password=787898").       //password
//                    append("&serverTimezone=UTC");   //setup server time)
//
//            Connection connection = DriverManager.getConnection(url.toString());
//            connection.setAutoCommit(false);
//            return connection;
//        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new IllegalStateException();
//        }
//    }
//
//    public static UserJdbcDAO getUserJdbsDAO() {
//        return new UserJdbcDAO(getMysqlConnection());
//    }

// Сверху для JDBC, Снизу для Hibernate

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/pre_project_crud?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "787898");
        configuration.setProperty("hibernate.show_sql", "true");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}