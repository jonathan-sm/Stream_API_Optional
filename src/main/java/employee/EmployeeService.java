package employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
    public interface EmployeeService {
        Employee add(String name, String surname);

        Employee remove(String name, String surname);

        Employee find(String name, String surname);

        Collection<Employee> findAll();


}
