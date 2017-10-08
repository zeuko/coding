package bitmanipulation;

import com.caramel.ctci.bitmanipulation.BasicBitOperations;
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
                {25, 4, true}
        });
    }

    @Test
    @Parameters(source = BasicBitOperationsTest.class, method = "getBitDataSample")
    public void givenNumber_whenGetBit_thenReturnCorrectValue(int number, int bit, boolean result) {
        Assert.assertTrue(BasicBitOperations.getBit(number, bit) == result);
    }


}
