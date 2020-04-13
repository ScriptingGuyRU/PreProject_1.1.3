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

@WebServlet("/editUser")
public class EditServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("EditUserPage.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            String password = req.getParameter("password");

            if (id == null || name == null || password == null){
                throw new DBException();
            }

            User user = userService.getUserById(id);

            if (userService.editUser(user, name, password)) {
                resp.setStatus(200);
                resp.sendRedirect("/");
            } else {
                throw new DBException();
            }

        } catch (DBException|NumberFormatException e) {
            resp.setStatus(403);
            resp.sendRedirect("/");
        }
    }
}
