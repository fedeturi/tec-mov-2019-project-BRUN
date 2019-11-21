package com.theweatherguy.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getUser();

    @Query("SELECT * FROM user WHERE mId LIKE :uuid")
    User getUser(String uuid);

    @Insert
    void addUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);


}
