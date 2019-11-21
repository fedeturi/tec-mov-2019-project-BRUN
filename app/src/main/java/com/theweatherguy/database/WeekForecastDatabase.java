package com.theweatherguy.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Day.class}, version = 1)
public abstract class WeekForecastDatabase extends RoomDatabase {

    private static volatile WeekForecastDatabase INSTANCE;

    static WeekForecastDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WeekForecastDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeekForecastDatabase.class, "WeekForecastDatabase").build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract DayDao dayDao();
}
