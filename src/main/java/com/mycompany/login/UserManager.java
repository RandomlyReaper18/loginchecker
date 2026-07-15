/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserManager {

    private static final String FILE = "users.json";

    private static Gson gson = new Gson();

    public static ArrayList<User> loadUsers() {

        try {

            File file = new File(FILE);

            if(!file.exists())
                return new ArrayList<>();

            Reader reader = new FileReader(file);

            Type type = new TypeToken<ArrayList<User>>(){}.getType();

            ArrayList<User> users = gson.fromJson(reader, type);

            reader.close();

            if(users == null)
                users = new ArrayList<>();

            return users;

        } catch(Exception e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static void saveUsers(ArrayList<User> users){

        try{

            Writer writer = new FileWriter(FILE);

            gson.toJson(users, writer);

            writer.flush();
            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static boolean register(String username,String password, String name){

        ArrayList<User> users = loadUsers();

        for(User u : users){

            if(u.getUsername().equalsIgnoreCase(username))
                return false;
        }

        users.add(new User(username,password,name));

        saveUsers(users);

        return true;
    }

    public static boolean login(String username,String password){

        ArrayList<User> users = loadUsers();

        for(User u : users){

            if(u.getUsername().equals(username)
                    && u.getPassword().equals(password))
                return true;
        }

        return false;
    }

}
