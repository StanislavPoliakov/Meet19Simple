package home.stanislavpoliakov.meet19simple;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.content.Context;


public class DatabaseGateway {
    private Context context;
    private ResultDAO dao;

    /**
     * Получаем вызывающий контекст в конструкторе. Это для инициализации из main
     * @param context контекст приложения
     */
    public DatabaseGateway(Context context) {
        this.context = context;
        dao = init();
    }

    public void saveResult(Result result) {
        if (dao.getResult() == null) dao.insert(result);
        else dao.update(result);
    }

    public Result loadResult() {
        return dao.getResult();
    }

    private ResultDAO init() {
        ResultDatabase database = Room.databaseBuilder(context, ResultDatabase.class, "result")
                .fallbackToDestructiveMigration()
                .build();
        return database.getWeatherDAO();
    }
}
