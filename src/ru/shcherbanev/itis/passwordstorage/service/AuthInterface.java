package ru.shcherbanev.itis.passwordstorage.service;

public interface AuthInterface {

    boolean register(String login, String password);
    boolean login(String login, String password);
}
