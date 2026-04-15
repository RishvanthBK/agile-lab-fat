public class PayrollService {

    // simple salary calculation
    public double calculateSalary(double basic, double bonus, double deductions) {
        return basic + bonus - deductions;
    }
}