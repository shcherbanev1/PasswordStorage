package ru.shcherbanev.itis.passwordstorage.storage;

import java.io.*;
import java.util.ArrayList;

public class FileStorage extends AbstractStorage {

    private final String path;

    public FileStorage(String path) {
        this.path = path;
        logins = new ArrayList<>();
        passwords = new ArrayList<>();
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
                    logins.add(login);
                    passwords.add(password);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < logins.size(); i++) {
                writer.write(logins.get(i) + " " + passwords.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
