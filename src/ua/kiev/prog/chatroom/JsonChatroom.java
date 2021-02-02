package ua.kiev.prog.chatroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonChatroom {
    private final List<Chatroom> list = new ArrayList<>();

    public JsonChatroom(Map<String, Chatroom> chatroom) {
        chatroom.forEach((k, v) -> list.add(v));
    }
}
