package ru.shcherbanev.itis.passwordstorage.storage;

import ru.shcherbanev.itis.passwordstorage.models.User;

import java.util.List;

public abstract class AbstractStorage {

    protected List<User> users;

    public abstract void readData(String source);
    public abstract void saveData();
    public abstract boolean userExists(String login);
    public abstract void addUser(String login, String password);

    public List<User> getUsers() {
        return users;
    }
}
