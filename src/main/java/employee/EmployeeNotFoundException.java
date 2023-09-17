package employee;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String messege) {
        super(messege);
    }
}
