package home.stanislavpoliakov.meet19simple;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "result_table")
public class Result {

    @PrimaryKey
    private int id;

    private double calculationResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(double calculationResult) {
        this.calculationResult = calculationResult;
    }

    public Result(double calculationResult) {
        this.calculationResult = calculationResult;
    }
}
