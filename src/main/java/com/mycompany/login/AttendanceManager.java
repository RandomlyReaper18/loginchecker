package com.mycompany.login;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AttendanceManager {

    private static final String FILE = "attendance.json";

    private static Gson gson = new Gson();

    public static ArrayList<Attendance> loadAttendance(){

        try{

            File file = new File(FILE);

            if(!file.exists())
                return new ArrayList<>();

            Reader reader = new FileReader(file);

            Type type = new TypeToken<ArrayList<Attendance>>(){}.getType();

            ArrayList<Attendance> list = gson.fromJson(reader,type);

            reader.close();

            if(list == null)
                list = new ArrayList<>();

            return list;

        }catch(Exception e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static void saveAttendance(ArrayList<Attendance> list){

        try{

            Writer writer = new FileWriter(FILE);

            gson.toJson(list,writer);

            writer.flush();
            writer.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
