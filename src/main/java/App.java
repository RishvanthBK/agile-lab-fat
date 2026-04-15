public class App {
    public static void main(String[] args) {

        PayrollService service = new PayrollService();

        double salary = service.calculateSalary(20000, 5000, 2000);

        System.out.println("Final Salary: " + salary);
    }
}