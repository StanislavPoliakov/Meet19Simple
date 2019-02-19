package home.stanislavpoliakov.meet19simple;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Result.class, version = 1)
public abstract class ResultDatabase extends RoomDatabase {
    public abstract ResultDAO getWeatherDAO();
}
