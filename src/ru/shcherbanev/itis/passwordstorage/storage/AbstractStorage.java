package ru.shcherbanev.itis.passwordstorage.storage;

import java.util.List;

public abstract class AbstractStorage {

    protected List<String> logins;
    protected List<String> passwords;

    public abstract void readData(String source);
    public abstract void saveData();


}
