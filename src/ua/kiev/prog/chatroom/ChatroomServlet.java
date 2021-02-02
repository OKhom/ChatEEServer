package ua.kiev.prog.chatroom;

import ua.kiev.prog.users.UserList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ChatroomServlet", value = "/chatroom")
public class ChatroomServlet extends HttpServlet {
    private final UserList chatroom = UserList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] buf = requestBodyToArray(request);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Chatroom room = Chatroom.fromJSON(bufStr);
        if (room != null)
            if (chatroom.getChatroom().containsKey(room.getChatroom()) || chatroom.getUsersList().containsKey(room.getChatroom())) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);    //409
            } else {
                chatroom.getChatroom().put(room.getChatroom(), room);
            }
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    private byte[] requestBodyToArray(HttpServletRequest req) throws IOException {
        InputStream is = req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
}
