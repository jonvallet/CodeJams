package com.jonvallet.core;

import java.io.*;
import java.util.Map;

public class PersistenceFile implements Persistence{

    public Map<String, User> load(){

        Map<String, User> users = null;

        try {
            FileInputStream saveFile = new FileInputStream("database.bin");
            ObjectInputStream restore = new ObjectInputStream(saveFile);
            users = (Map<String, User>) restore.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return users;
    }

    public void save(Map<String, User> users) {

        String fileNameOut = "database.bin";

        try {
            FileOutputStream fout = new FileOutputStream(fileNameOut);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
