import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrycja.lisowska on 11.10.2017.
 */
public class AnagramsInTextTest {

    AnagramsInText underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new AnagramsInText();
    }


    @Test
    public void test_long() {
        String text = "cbabadcbbabbcbabaabccbabc";
        String s = "abbc";

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(6);
        expected.add(9);
        expected.add(11);
        expected.add(12);
        expected.add(20);
        expected.add(21);

        List<Integer> solution = underTest.solution(text, s);

        Assert.assertEquals(expected, solution);

    }

    @Test
    public void test_short() {
        String text = "cbabc";
        String s = "abbc";

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);


        List<Integer> solution = underTest.solution(text, s);

        Assert.assertEquals(expected, solution);

    }

    @Test
    public void test_textSameSizeAsAString() {
        String text = "babc";
        String s = "abbc";

        List<Integer> expected = new ArrayList<>();
        expected.add(0);


        List<Integer> solution = underTest.solution(text, s);

        Assert.assertEquals(expected, solution);

    }

    @Test
    public void test_textSameSizeAsAStringButNotAnagram() {
        String text = "aaaa";
        String s = "abbc";

        List<Integer> expected = new ArrayList<>();

        List<Integer> solution = underTest.solution(text, s);

        Assert.assertEquals(expected, solution);

    }

    @Test
    public void test_textShorterThanString() {
        String text = "cb";
        String s = "abbc";

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);


        List<Integer> solution = underTest.solution(text, s);

        Assert.assertEquals(expected, solution);

    }
}
