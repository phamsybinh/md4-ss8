package ra.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.entity.Employee;
import ra.orm.repository.IEmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
// quan ly phien lam viec
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void remove(int id) {

    }
}
