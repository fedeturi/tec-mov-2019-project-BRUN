package com.theweatherguy.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class UserDBRepository {

    @SuppressLint("StaticFieldLeak")
    private static UserDBRepository sUserDBRepository;

    private UserDao mUserDao;

    private UserDBRepository(Context context) {
        Context appContext = context.getApplicationContext();
        UserDatabase database = Room.databaseBuilder(appContext, UserDatabase.class, "user")
                .allowMainThreadQueries().build();
        mUserDao = database.getUserDao();
    }

    public static UserDBRepository get(Context context) {
        if (sUserDBRepository == null) {
            sUserDBRepository = new UserDBRepository(context);
        }
        return sUserDBRepository;
    }

    public List<User> getUser() {
        return mUserDao.getUser();
    }

    public User getUser(String id) {
        return mUserDao.getUser(id);
    }

    public void addUser(User user) {
        mUserDao.addUser(user);
    }

    public void updateUser(User user) {
        mUserDao.updateUser(user);
    }

    public void deleteUser(User user) {
        mUserDao.deleteUser(user);
    }
}
