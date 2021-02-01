package ua.kiev.prog;

public class Users {
    private String login;
    private String status;

    Users(String login) {
        this.login = login;
        this.status = "offline";
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
