import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void AdditionTest() {
        System.out.println("add");
        Integer a = 15;
        Integer b = 15;
        Integer expResult = 30;
        Integer result = Main.addition(a, b);
        assertEquals(expResult, result);

        assertEquals(null, Main.addition(15, null));
        assertEquals(null, Main.addition(null, 15));
        assertEquals(null, Main.addition(null, null));
    }
}