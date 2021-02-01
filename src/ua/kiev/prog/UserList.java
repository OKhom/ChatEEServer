package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class UserList {
    private static final UserList userList = new UserList();
    private static final Map<String, Users> usersList = new HashMap<String, Users>();
    private static final Map<String, String> users = new HashMap<String, String>();
    private static final Map<String, Chatroom> chatroom = new HashMap<String, Chatroom>();
    static {
        usersList.put("user1", new Users("user1"));
        users.put("user1", "qwerty");
        usersList.put("user2", new Users("user2"));
        users.put("user2", "qazwsx");
    }

    UserList() {}

    public static UserList getInstance() {
        return userList;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public void setUser(String login, String password) {
        users.put(login, password);
    }

    public Map<String, Users> getUsersList() {
        return usersList;
    }

    public Map<String, Chatroom> getChatroom() {
        return chatroom;
    }

    public synchronized String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(new JsonUsers(usersList));
    }

    public synchronized String crToJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(new JsonChatroom(chatroom));
    }

}
