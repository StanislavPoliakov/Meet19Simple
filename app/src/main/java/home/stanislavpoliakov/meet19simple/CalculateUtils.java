package home.stanislavpoliakov.meet19simple;

/**
 * Класс, описывающий арифметические операции для калькулятора
 */
public class CalculateUtils {

    /**
     * Метод вычисления суммы двух вещественных чисел
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма
     */
    public double addition(double a, double b) {
        return a + b;
    }

    /**
     * Метод вычисления разности двух вещественных чисел
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность
     */
    public double subtraction(double a, double b) {
        return a - b;
    }

    /**
     * Метод вычисления произведения двух вещественных чисел
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение
     */
    public double multiplication(double a, double b) {
        return a * b;
    }

    /**
     * Метод вычисления частного двух вещественных чисел
     * @param a делимое
     * @param b делитель
     * @return частное
     */
    public double division(double a, double b) {
        return a / b;
    }

    /**
     * Приватный метод для вычисления частного двух вещественных чисел
     * @param a делимое
     * @param b делитель
     * @return частное
     */
    private double privateDivision(double a, double b) {
        return a / b;
    }
}
