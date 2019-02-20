package home.stanislavpoliakov.meet19simple;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Модульные тесты вычислений CalculateUtils
 */
public class CalculateUtilsTest {
    private CalculateUtils calculateUtils;
    private double delta = 0.00000001;

    @Before
    public void setUp() throws Exception {
        calculateUtils = new CalculateUtils();
    }

    @Test
    public void addition() {
        double d1 = 1;
        double d2 = 2;
        assertEquals(3, calculateUtils.addition(d1, d2), delta);
    }

    @Test
    public void subtraction() {
        double d1 = 2;
        double d2 = -4;
        assertEquals(6, calculateUtils.subtraction(d1, d2), delta);
    }

    @Test
    public void multiplication() {
        double d1 = 4;
        double d2 = 6;
        assertEquals(24, calculateUtils.multiplication(d1, d2), delta);
    }

    @Test
    public void division() {
        double d1 = 74;
        double d2 = 2;
        assertEquals(37, calculateUtils.division(d1, d2), delta);
    }

    @Test
    public void positiveInfinity() {
        double d1 = 23;
        double d2 = 0;
        assertEquals(Double.POSITIVE_INFINITY, calculateUtils.division(d1, d2), delta);
    }

    @Test
    public void negativeInfinity() {
        double d1 = -12;
        double d2 = 0;
        assertEquals(Double.NEGATIVE_INFINITY, calculateUtils.division(d1, d2), delta);
    }

    @Test
    public void checkNaN() {
        double d1 = 0;
        double d2 = 0;
        assertEquals(Double.NaN, calculateUtils.division(d1, d2), delta);
    }

    @Test
    public void checkNaNFromInfinity() {
        double d1 = Double.POSITIVE_INFINITY;
        double d2 = Double.POSITIVE_INFINITY;
        assertEquals(Double.NaN, calculateUtils.division(d1, d2), delta);

        d1 = Double.NEGATIVE_INFINITY;
        assertEquals(Double.NaN, calculateUtils.division(d1, d2), delta);
    }

    @Test
    public void checkPrivateDivision() {
        Class utilsClass = calculateUtils.getClass();
        try {
            Method method = utilsClass.getDeclaredMethod("privateDivision", double.class, double.class);
            method.setAccessible(true);
            double d1 = 0;
            double d2 = 5;
            System.out.println(method);
            double res = (double) method.invoke(utilsClass.newInstance(), d1, d2);
            assertEquals(0.0, res, delta);
            method.setAccessible(false);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}