package com.theweatherguy.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DayDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Day day);

    @Update
    void updateDay(Day day);

    @Delete
    void deleteDay(Day day);

    @Query("DELETE FROM week_forecast")
    void deleteAll();

    @Query("SELECT * FROM week_forecast ")
    List<Day> getAllDays();

    @Query("SELECT * FROM week_forecast WHERE id == :id")
    Day getDayById(int id);

}
