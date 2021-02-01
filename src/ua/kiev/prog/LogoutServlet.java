package ua.kiev.prog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    private final UserList userList = UserList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a)) {
            Users logout = userList.getUsersList().get(login);
            logout.setStatus("offline");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
