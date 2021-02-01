package ua.kiev.prog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserListServlet", value = "/userlist")
public class UserListServlet extends HttpServlet {
    private final UserList userList = UserList.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");

        String json = userList.toJSON();
        if (json != null) {
            PrintWriter pw = response.getWriter();
            pw.print(json);
        }
    }
}
