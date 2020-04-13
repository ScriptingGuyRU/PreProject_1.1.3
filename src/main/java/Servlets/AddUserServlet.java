package Servlets;

import entities.User;
import exception.DBException;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddUserPage.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("name");
            String password = req.getParameter("password");

            if (name == null || password == null) {
                throw new DBException();
            }

            User user = new User(name, password);

            if (userService.addUser(user)) {
                resp.setStatus(200);
                resp.sendRedirect("/");
            } else {
                throw new DBException();
            }
        } catch (DBException e) {
            resp.setStatus(403);
            resp.sendRedirect("/");
        }
    }
}
