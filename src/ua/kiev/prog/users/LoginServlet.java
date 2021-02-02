package ua.kiev.prog.users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final UserList userList = UserList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (request.getParameter("connect").equals("signup")) {
            if (userList.getUsers().containsKey(login)) response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE); //406
            else {
                userList.setUser(login, password);
                Users usersStatus = new Users(login);
                userList.getUsersList().put(login, usersStatus);
                response.setStatus(HttpServletResponse.SC_OK);
            }
        } else if (request.getParameter("connect").equals("signin")) {
            String curUser = userList.getUsers().get(login);
            if (password.equals(curUser)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userLogin", login);
                userList.getUsersList().get(login).setStatus("online");
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
        }
    }
}
