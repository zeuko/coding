import org.junit.Assert;
import org.junit.Test;

/**
 * Created by patrycja.lisowska on 11.10.2017.
 */
public class UniqueCharactersInStringTest {


    @Test
    public void solution_testUnique() throws Exception {
        String s = "abcqweryjp";
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean solution = underTest.solution(s);

        Assert.assertTrue(solution);
    }


    @Test
    public void solutionNoAdditionalStructure_testUnique() throws Exception {
        String s = "abcqweryjp";
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean solution = underTest.solutionNoAdditionalStructure(s);

        Assert.assertTrue(solution);
    }


    @Test
    public void solutionUsingBitManipulation_testUnique() throws Exception {
        String s = "abcqweryjp";
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean solution = underTest.solutionUsingBitManipulation(s);

        Assert.assertTrue(solution);
    }

    @Test
    public void solution_testNotUnique() throws Exception {
        String s = "abcqweryjpa";
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean solution = underTest.solution(s);

        Assert.assertFalse(solution);
    }


    @Test
    public void solutionNoAdditionalStructure_testNotUnique() throws Exception {
        String s = "abcqweryjpa";
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean solution = underTest.solutionNoAdditionalStructure(s);

        Assert.assertFalse(solution);
    }


    @Test
    public void solutionUsingBitManipulation_testNotUnique() throws Exception {
        String s = "abcqweryjpa";
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean solution = underTest.solutionUsingBitManipulation(s);

        Assert.assertFalse(solution);
    }
}
