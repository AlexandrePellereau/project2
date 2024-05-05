package com.alexpell.championpedia.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String USER_TABLE = "user";
    public static final String COMMENT_TABLE = "comment";
    public static final String DATABASE_NAME = "Championpedia.DB";
    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public abstract UserDAO getUserDAO();

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
