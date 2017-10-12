import com.caramel.data.structures.linkedlist.DuplicatesRemoval;
import com.caramel.data.structures.linkedlist.SingleLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by patrycja.lisowska on 12.10.2017.
 */
public class DuplicatesRemovalTests {

    DuplicatesRemoval underTest = new DuplicatesRemoval();

    @Test
    public void testSingleLinkedListWithNoDuplicates() throws Exception {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("abc");
        list.add("bcd");
        list.add("dbe");
        list.add("aer");
        list.add("wer");

        SingleLinkedList<String> actual = underTest.removeDuplicates(list);

        Assert.assertTrue(actual.equals(list));

    }

    @Test
    public void testSingleLinkedListWithOneDuplicate() throws Exception {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("abc");
        list.add("bcd");
        list.add("dbe");
        list.add("abc");
        list.add("wer");

        SingleLinkedList<String> actual = underTest.removeDuplicates(list);

        SingleLinkedList<String> expected = new SingleLinkedList<>();
        expected.add("abc");
        expected.add("bcd");
        expected.add("dbe");
        expected.add("wer");

        Assert.assertEquals(4, actual.getSize());

    }
}
