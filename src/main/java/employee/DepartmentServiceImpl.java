package employee;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final  EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
        employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId){
        return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment()== departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException(" Not Found Exception"));

    }


    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId){
        return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment()== departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException(" Not Found Exception"));
    }


    @Override
    public Collection<Employee> getEmployee(Integer departmentId) {
           return employeeService.findAll()
                .stream()
                .filter(e->e.getDepartment()== departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployee() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
