package com.example.myapplication.Dataset;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DaoUser {
    Context c;
    User user;
    ArrayList<User> userList;
    SQLiteDatabase sql;
    String bd = "usersBD";
    String table = "create table if not exists user(id integer primary key autoincrement, full_name text, " +
            "email text, password text, confirm_password text, genre text, country text, birth_day integer, birth_month integer, birth_year integer, objective text," +
            "initial_score float, monitoring_score float, training_days integer)";

    public DaoUser(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(table);
        user = new User();
    }

    public boolean insertUser(User user){
        if(buscar(user.getEmail())==0){
            ContentValues cv =  new ContentValues();
            cv.put("full_name", user.getFullName());
            cv.put("email", user.getEmail());
            cv.put("password", user.getPassword());
            cv.put("confirm_password", user.getPassword());
            cv.put("genre", user.getGenre());
            cv.put("country", user.getCountry());
            cv.put("birth_day", user.getDay());
            cv.put("birth_month", user.getMonth());
            cv.put("birth_year", user.getYear());
            cv.put("objective", user.getObjective());
            cv.put("initial_score", user.getInitialScore());
            cv.put("monitoring_score", user.getMonitoringScore());
            cv.put("training_days", user.getTrainingDays());
            return (sql.insert("user", null, cv)>0);
        } else{
            return false;
        }
    }

    public int buscar(String email){
        int x = 0;
            userList = selectUsers();
        for (User user: userList){
            if (user.getEmail().equals(email)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<User> selectUsers(){
        ArrayList<User> userList = new ArrayList<User>();
        Cursor cr = sql.rawQuery("select * from user", null);
        if(cr!=null && cr.moveToFirst()){
            do {
                User u = new User();
                u.setId(cr.getInt(0));
                u.setFullName(cr.getString(1));
                u.setEmail(cr.getString(2));
                u.setPassword(cr.getString(3));
                u.setConfirmPassword(cr.getString(4));
                u.setGenre(cr.getString(5));
                u.setCountry(cr.getString(6));
                u.setDay(cr.getInt(7));
                u.setMonth(cr.getInt(8));
                u.setYear(cr.getInt(9));
                u.setObjective(cr.getString(10));
                u.setInitialScore(cr.getFloat(11));
                u.setMonitoringScore(cr.getFloat(12));
                u.setTrainingDays(cr.getInt(13));
                userList.add(u);
            } while(cr.moveToNext());
        }
        return userList;
    }

    public int login(String email, String password){
        int a = 0;
        Cursor cr = sql.rawQuery("select * from user", null);
        if(cr!=null && cr.moveToFirst()){
            do {
                if(cr.getString(2).equals(email) && cr.getString(3).equals(password))
                    a++;
            } while(cr.moveToNext());
        }
        return a;
    }

    public User getUser(String email, String password){
        userList = selectUsers();
        for (User u: userList){
            if(u.getEmail().equals(email) && u.getPassword().equals(password))
                return u;
        }
        return null;
    }

    public User getUserById(int id){
        userList = selectUsers();
        for (User u: userList){
            if(u.getId() == id)
                return u;
        }
        return null;
    }

    public boolean updateUser(User u){
        ContentValues cv =  new ContentValues();
        cv.put("full_name", u.getFullName());
        cv.put("email", u.getEmail());
        cv.put("password", u.getPassword());
        cv.put("confirm_password", u.getPassword());
        cv.put("genre", u.getGenre());
        cv.put("country", u.getCountry());
        cv.put("birth_day", u.getDay());
        cv.put("birth_month", u.getMonth());
        cv.put("birth_year", u.getYear());
        cv.put("objective", u.getObjective());
        cv.put("initial_score", u.getInitialScore());
        cv.put("monitoring_score", u.getMonitoringScore());
        cv.put("training_days", u.getTrainingDays());
        return (sql.update("user", cv, "id="+u.getId(), null)>0);
    }
}
