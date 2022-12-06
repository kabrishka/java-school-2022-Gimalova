package ru.croc.task17.database;

import java.util.Objects;

public class User {
    String login;

    public User(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User guest = (User) obj;
        return (login != null && login.equals(guest.login));
    }
}
