package employee;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> Employees;

    public EmployeeServiceImpl() {
        this.Employees = new HashMap<>();
        add("владимир", "Петров");
        add("владимир", "Сидоров");
        add("владимир", "Иванов");
        add("владимир", "Васильев");
        add("владимир", "Воронов");
        add("владимир", "Гусев");
        add("владимир", "Николаев");

    }

    @Override
    public Employee add(String name, String surname) {
        checkTypeName(name, surname);
        StringUtils.capitalize(name.toLowerCase());
        StringUtils.capitalize(surname.toLowerCase());
        Employee employee = new Employee(name, surname);
        if (Employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }
        Employees.put(employee.getFullName(), employee);
        return employee;

    }

    @Override
    public Employee remove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (Employees.containsKey(employee.getFullName())) {
            return Employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee find(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (Employees.containsKey(employee.getFullName())) {
            return Employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(Employees.values());
    }

    private void checkTypeName(String... values) {
        for (String value : values) {
            }

        }
    }
