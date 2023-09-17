package employee;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String messege) {
        super(messege);
    }
}
