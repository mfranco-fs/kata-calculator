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
}
