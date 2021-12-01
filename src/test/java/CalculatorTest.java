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
        long result = calc.add("");
        //Assert
        assertEquals(0,result);
    }

    @Test
    public void testForSingleNumber(){
        //Act
        long result = calc.add("5");
        //Assert
        assertEquals(5, result);
    }

    @Test
    public void testForTwoNumbers(){
        //Act
        long result = calc.add("5,2");
        //Assert
        assertEquals(7, result);
    }

    @Test
    public void testForMultipleNumbers(){
        //Act
        long result = calc.add("5,2,50,100");
        //Assert
        assertEquals(157, result);
    }

    @Test
    public void testForNewLineSeparator(){
        //Act
        long result = calc.add("5,2,50\n100");
        //Assert
        assertEquals(157, result);
    }

    @Test
    public void testForDifferentDelimeter(){
        //Act
        long result = calc.add("//;\n5,2,50\n100;4");
        //Assert
        assertEquals(161, result);
    }

}
