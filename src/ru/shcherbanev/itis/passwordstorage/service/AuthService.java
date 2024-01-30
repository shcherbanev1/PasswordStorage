package ru.shcherbanev.itis.passwordstorage.service;

import ru.shcherbanev.itis.passwordstorage.models.User;
import ru.shcherbanev.itis.passwordstorage.storage.AbstractStorage;

public class AuthService implements AuthInterface {

    private final AbstractStorage db;

    public AuthService(AbstractStorage db) {
        this.db = db;
    }

    @Override
    public boolean register(String login, String password) {
        if (!db.userExists(login)) {
            db.addUser(login, password);
            db.saveData();
            return true; // Регистрация успешна
        } else {
            return false; // Логин уже занят
        }
    }

    @Override
    public boolean login(String login, String password) {
        for (User user : db.getUsers()) {
            if (user.getUsername().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
