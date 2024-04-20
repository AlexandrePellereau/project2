package com.alexpell.championpedia.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.alexpell.championpedia.LoginLog;

@Database(entities = {LoginLog.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String LOGINLOG_TABLE = "login_log";
    private static final String DATABASE_NAME = "LoginLog.DB";
    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public abstract LoginLogDAO loginLogDAO();

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }

}
