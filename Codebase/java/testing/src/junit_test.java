import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class junit_test
{
    myClass t = new myClass();

    @Test
    public void testMethodIncorrect()
    {
        assertNotEquals(11, t.checkbool(11, true, false));
    }

    @Test
    public void testMethodCorrect()
    {
        assertEquals(11, t.checkbool(10, true, false));
    }

    @Test
    public void testMedianYXZ()
    {
        assertEquals(10, t.median(10, 9, 11));
    }

    @Test
    public void testMedianZXY()
    {
        assertEquals(10, t.median(10, 11, 9));
    }

    @Test
    public void testMedianXYZ()
    {
        assertEquals(10, t.median(9, 10, 11));
    }

    @Test
    public void testMedianZYX()
    {
        assertEquals(10, t.median(11, 10, 9));
    }

    @Test
    public void testMedianZ()
    {
        assertEquals(10, t.median(9, 11, 10));
    }
}