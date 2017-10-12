import com.caramel.data.structures.linkedlist.SingleLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by patrycja.lisowska on 12.10.2017.
 */
public class SingleLinkedListTests {

    @Test
    public void correctSizeAfterAddingAndRemovingTests() throws Exception {

        SingleLinkedList<String> list = new SingleLinkedList<>();

        Assert.assertTrue(list.getSize() == 0);
        System.out.println(list);
        list.add("abc");
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 1);

        list.add("def");
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 2);

        list.add("ghi");
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 3);

        list.add("jkl");
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 4);

        list.remove(0);
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 3);

        list.remove(1);
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 2);

        list.remove(0);
        System.out.println(list);
        Assert.assertTrue(list.getSize() == 1);

    }
}
