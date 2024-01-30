package ru.shcherbanev.itis.passwordstorage.storage;

import ru.shcherbanev.itis.passwordstorage.models.User;

import java.io.*;
import java.util.ArrayList;

public class FileStorage extends AbstractStorage {

    private final String path;

    public FileStorage(String path) {
        this.path = path;
        users = new ArrayList<>();
    }


    @Override
    public void readData(String source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String login = parts[0];
                    String password = parts[1];
                    User user = new User(login, password);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (User user : users) {
                writer.write(user.getUsername() + " " + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean userExists(String login) {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(String login, String password) {
        User newUser = new User(login, password);
        users.add(newUser);
    }
}
