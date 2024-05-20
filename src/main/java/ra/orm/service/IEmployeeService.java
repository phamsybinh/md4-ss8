package ra.orm.service;

import ra.orm.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(int id);
    void update(int id, Employee employee);
    void remove(int id);
}
