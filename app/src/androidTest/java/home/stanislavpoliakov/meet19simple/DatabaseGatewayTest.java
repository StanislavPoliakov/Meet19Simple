package home.stanislavpoliakov.meet19simple;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseGatewayTest {
    private ResultDatabase resultDatabase;
    private ResultDAO resultDAO;
    private double delta = 0.1;

    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getContext();
        resultDatabase = Room.inMemoryDatabaseBuilder(context, ResultDatabase.class).build();
        resultDAO = resultDatabase.getResultDAO();
    }

    @Test
    public void writeAndReadResult() {
        CalculateUtils calculateUtils = new CalculateUtils();
        double d1 = 0.23;
        double d2 = 12.8729;
        double calc = calculateUtils.multiplication(d1, d2);

        Result result = new Result(calc);
        if (resultDAO.getResult() == null) resultDAO.insert(result);
        else resultDAO.update(result);

        assertEquals(calc, resultDAO.getResult().getCalculationResult(), delta);
    }

    /*@Test
    public void saveResult() {
    }

    @Test
    public void loadResult() {
    }*/

    @After
    public void closeDB() {
        resultDatabase.close();
    }
}