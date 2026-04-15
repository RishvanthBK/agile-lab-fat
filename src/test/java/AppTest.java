import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testSalaryCalculation() {
        PayrollService service = new PayrollService();

        double result = service.calculateSalary(20000, 5000, 2000);

        assertEquals(23000, result);
    }

    @Test
    public void testZeroSalary() {
        PayrollService service = new PayrollService();

        double result = service.calculateSalary(0, 0, 0);

        assertEquals(0, result);
    }
}