package com.theweatherguy.database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class WeekForecastRepository {

    private DayDao dayDao;
    private List<Day> allDays;

    public WeekForecastRepository(Application application) {
        WeekForecastDatabase database = WeekForecastDatabase.getDatabase(application);
        dayDao = database.dayDao();
    }

    public List<Day> getAllDays() {
        try {
            allDays = new getDaysAsyncTask(dayDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allDays;
    }

    public void insert(Day day) {
        new insertDaysAsyncTask(dayDao).execute(day);
    }


    public static class insertDaysAsyncTask extends AsyncTask<Day, Void, Void> {

        private DayDao asyncTaskDayDao;

        insertDaysAsyncTask(DayDao dayDao) {
            asyncTaskDayDao = dayDao;
        }

        @Override
        protected Void doInBackground(Day... days) {
            asyncTaskDayDao.insert(days[0]);
            return null;
        }
    }

    public static class getDaysAsyncTask extends AsyncTask<Void, Void, List<Day>> {

        private DayDao asyncTaskDayDao;

        getDaysAsyncTask(DayDao dayDao) {
            asyncTaskDayDao = dayDao;
        }

        @Override
        protected List<Day> doInBackground(Void... voids) {

            return asyncTaskDayDao.getAllDays();
        }
    }

}
