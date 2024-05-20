package ra.orm.repository;

import ra.orm.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(int id);
    void update(int id, Employee employee);
    void remove(int id);
}
