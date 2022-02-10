import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setup(){ calc = new Calculator(); }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void add_none_returnsDefault(){
        assertEquals(0, calc.add(""));
    }

    @Test
    public void add_singleValue_returnsSameValue(){
        assertEquals(5, calc.add("5"));
    }

    @Test
    public void add_twoNumbers_returnsTheSum(){
        assertEquals(7, calc.add("5,2"));
    }

    @Test
    public void add_multipleNumbers_returnsTheSum(){
        assertEquals(157, calc.add("5,2,50,100"));
    }

    @Test
    public void add_multipleNumbersWithNewLine_returnsTheSum(){
        assertEquals(157, calc.add("5,2,50\n100"));
    }

    @Test
    public void add_multipleNumbersWithNewDelimeter_returnsTheSum(){
        assertEquals(161, calc.add("//;\n5,2,50\n100;4"));
    }

    @Test
    public void add_negative_throws1() {
        thrown.expect(IllegalArgumentException.class);
        long result = calc.add("//;\n5,2,50\n100;-4");
    }

    @Test
    public void add_negative_throws2() {
        thrown.expect(IllegalArgumentException.class);
        long result = calc.add("//;\n5,2,50\n100;-4,-45");
    }

    //Not recommended, it's better to use the existing rule but leaving for ilustration purposes
    @Test (expected = IllegalArgumentException.class)
    public void add_negative_throws3() {
        long result = calc.add("//;\n5,2,50\n100;-4,-45");
    }

    @Test
    public void add_negative_throws4() {
        thrown.expect(IllegalArgumentException.class);
        long result = calc.add("//;\n5,2,50\n100;-4,-45");
    }

    @Test
    public void testForFourDigitNumbers() {
        assertEquals(57, calc.add("//;\n5,2,50\n1000"));
    }


    @Test
    public void testForMultiCharDelimeters() {
        assertEquals(6, calc.add("//[hola]\n1hola2hola3"));
    }


    @Test
    public void testForMultipleDelimeters() {
        assertEquals(6, calc.add("//[hi][there]\n1hi2there3"));
    }
}
