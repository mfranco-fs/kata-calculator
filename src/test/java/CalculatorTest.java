import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setup(){ calc = new Calculator(); }

    @Test
    public void testForEmpty(){
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
    public void testForSingleNumber(){
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
    public void testForTwoNumbers(){
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
    public void testForMultipleNumbers(){
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
    public void testForNewLineSeparator(){
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
    public void testForDifferentDelimeter(){
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
    public void testForNegativeValue() {
        //Act
        try{
            long result = calc.add("//;\n5,2,50\n100;-4");
        } catch(Exception e){
            assertEquals("Negatives not allowed: -4", e.getMessage());
        }
    }

    @Test
    public void testForNegativeValues() {
        //Act
        try{
            long result = calc.add("//;\n5,2,50\n100;-4,-45");
        } catch(Exception e){
            //assert
            assertEquals("Negatives not allowed: -4,-45", e.getMessage());
        }
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

}
