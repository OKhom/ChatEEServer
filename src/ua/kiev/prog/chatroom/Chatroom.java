package ua.kiev.prog.chatroom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Chatroom {
    private String chatroom;
    private List<String> members;

    public Chatroom(String chatroom, List<String> members) {
        this.chatroom = chatroom;
        this.members = members;
    }
    public static Chatroom fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Chatroom.class);
    }

    public String getChatroom() {
        return chatroom;
    }

    public void setChatroom(String chatroom) {
        this.chatroom = chatroom;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatroom='" + chatroom + '\'' +
                ", members=" + members +
                '}';
    }
}
