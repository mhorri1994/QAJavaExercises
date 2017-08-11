import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Matthew on 09/08/2017.
 */
public class JUnitTests {
    @Test
    public void testSumOne(){
        Assert.assertEquals(1, UniqueSum.calculateUniqueSum(1, 2, 2));

    }
    @Test
    public void testSumTwo(){
        Assert.assertEquals(6, UniqueSum.calculateUniqueSum(1, 2, 3));
    }
    @Test
    public void testSumThree(){
        Assert.assertEquals(0, UniqueSum.calculateUniqueSum(2, 0, 2));
    }
    @Test
    public void testSumFour(){
        Assert.assertEquals(0, UniqueSum.calculateUniqueSum(2, 2, 2));
    }
}
