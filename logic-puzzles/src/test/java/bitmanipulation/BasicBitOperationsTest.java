package bitmanipulation;

import com.caramel.bitmanipulation.BasicBitOperations;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by patrycja.lisowska on 08.10.2017.
 */
@RunWith(JUnitParamsRunner.class)
public class BasicBitOperationsTest {

    public static Collection<Object[]> getBitDataSample() {
        return Arrays.asList(new Object[][]{
                {1, 0, true},
                {2, 1, true},
                {2, 0, false},
                {16, 4, true},
                {16, 3, false},
                {25, 4, true},
                // some longer binary values
                {0b11011010101101, 0, true},
                {0b11011010101101, 1, false},
                {0b11011010101101, 10, true},
                // checking sign bit
                {-1, Integer.SIZE - 1, true},
                {1, Integer.SIZE - 1, false}
        });
    }

    @Test
    @Parameters(source = BasicBitOperationsTest.class, method = "getBitDataSample")
    public void givenNumber_whenGetBit_thenReturnCorrectValue(int number, int bit, boolean result) {
        boolean bitValue = BasicBitOperations.getBit(number, bit);
        Assert.assertEquals(result, bitValue);
    }

    public static Collection<Object[]> setBitDataSample() {
        return Arrays.asList(new Object[][]{
                {0, 0, 1},
                {2, 0, 3},
                // some longer binary values
                {0b10001, 0, 0b10001},
                {0b10001, 1, 0b10011},
                {0b10001, 2, 0b10101},
                {0b10001, 3, 0b11001},
                {0b10001, 4, 0b10001},
                {0b10001, 5, 0b110001},
                // setting sign bit should give 2-complement, negative value:
                {2, 31, Integer.MIN_VALUE + 2},
                // setting sign bit for negative value should give the same value
                {-2, 31, -2},
        });
    }

    @Test
    @Parameters(source = BasicBitOperationsTest.class, method = "setBitDataSample")
    public void givenNumber_whenSetBit_thenReturnCorrectValue(int number, int bit, int result) {
        int newValue = BasicBitOperations.setBit(number, bit);
        Assert.assertEquals(result, newValue);
    }

    public static Collection<Object[]> clearBitDataSample() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {2, 1, 0},
                // some longer binary values
                {0b10001, 0, 0b10000},
                {0b10001, 1, 0b10001},
                {0b10001, 2, 0b10001},
                {0b10001, 3, 0b10001},
                {0b10001, 4, 0b00001},
                {0b10001, 5, 0b10001},
                // clearing sign bit should give 2-complement value:
                {-2, 31, Integer.MAX_VALUE - 2 + 1},
                {-89112, 31, Integer.MAX_VALUE - 89112 + 1},
                {Integer.MIN_VALUE, 31, 0},
                // clearing sign bit for positive value should give the same value
                {2, 31, 2},
        });
    }

    @Test
    @Parameters(source = BasicBitOperationsTest.class, method = "clearBitDataSample")
    public void givenNumber_whenClearBit_thenReturnCorrectValue(int number, int bit, int result) {
        int newValue = BasicBitOperations.clearBit(number, bit);
        Assert.assertEquals(result, newValue);
    }


}
