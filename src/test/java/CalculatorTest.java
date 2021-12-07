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
        //Act
        long result = 0;
        try{
            result = calc.add("");
        } catch(Exception e){
        }
        //Assert
        assertEquals(0,result);
    }

    @Test
    public void add_singleValue_returnsSameValue(){
        //Act
        long result = 0;
        try{
            result = calc.add("5");
        } catch(Exception e){
        }
        //Assert
        assertEquals(5, result);
    }

    @Test
    public void add_twoNumbers_returnsTheSum(){
        //Act
        long result = 0;
        try{
            result = calc.add("5,2");
        } catch(Exception e){
        }
        //Assert
        assertEquals(7, result);
    }

    @Test
    public void add_multipleNumbers_returnsTheSum(){
        //Act
        long result = 0;
        try{
            result = calc.add("5,2,50,100");
        } catch(Exception e){
        }
        //Assert
        assertEquals(157, result);
    }

    @Test
    public void add_multipleNumbersWithNewLine_returnsTheSum(){
        //Act
        long result = 0;
        try{
            result = calc.add("5,2,50\n100");
        } catch(Exception e){
        }

        //Assert
        assertEquals(157, result);
    }

    @Test
    public void add_multipleNumbersWithNewDelimeter_returnsTheSum(){
        //Act
        long result = 0;
        try{
            result = calc.add("//;\n5,2,50\n100;4");
        } catch(Exception e){
        }
        //Assert
        assertEquals(161, result);
    }

    @Test
    public void add_negative_throws1() {
        //Act
        try{
            long result = calc.add("//;\n5,2,50\n100;-4");
        } catch(Exception e){
            assertEquals("Negatives not allowed: -4", e.getMessage());
        }
    }

    @Test
    public void add_negative_throws2() {
        //Act
        try{
            long result = calc.add("//;\n5,2,50\n100;-4,-45");
        } catch(Exception e){
            //assert
            assertEquals("Negatives not allowed: -4,-45", e.getMessage());
        }
    }

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
        //Act
        long result = 0;
        try{
            result = calc.add("//;\n5,2,50\n1000");
        } catch(Exception e){
        }
        //Assert
        assertEquals(57, result);
    }


    @Test
    public void testForMultiCharDelimeters() {
        //Act
        long result = 0;
        try{
            result = calc.add("//[hola]\n1hola2hola3");
        } catch(Exception e){
        }
        //Assert
        assertEquals(6, result);
    }


    @Test
    public void testForMultipleDelimeters() {
        //Act
        long result = 0;
        try{
            result = calc.add("//[hi][there]\n1hi2there3");
        } catch(Exception e){
        }
        //Assert
        assertEquals(6, result);
    }
}
