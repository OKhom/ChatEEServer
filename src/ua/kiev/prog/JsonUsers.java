package ua.kiev.prog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUsers {
    private final List<Users> list = new ArrayList<>();

    public JsonUsers(Map<String, Users> sourceUsers) {
        sourceUsers.forEach((k, v) -> list.add(v));
    }
}
