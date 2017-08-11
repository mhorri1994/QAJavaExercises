import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Matthew on 09/08/2017.
 */
public class JUnitTests {
    @Test
    public void testNotTooHotSummer(){
        Assert.assertFalse(TooHot.checkIfItIsTooHot(95, true));
    }
    @Test
    public void testTooHotSummer(){
        Assert.assertTrue(TooHot.checkIfItIsTooHot(110, true));
    }
    @Test
    public void testNotTooHotWinter(){
        Assert.assertFalse(TooHot.checkIfItIsTooHot(66, false));
    }
    @Test
    public void testTooHotWinter(){
        Assert.assertTrue(TooHot.checkIfItIsTooHot(120, true));
    }
}
