package DaoImpl;

import Dao.EmployeeDao;
import pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = EntityUtil.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        System.out.println(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = EntityUtil.createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employeeList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employeeList;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        EntityManager entityManager = EntityUtil.createEntityManager();
        entityManager.getTransaction().begin();
        Employee empForUpdate = entityManager.find(Employee.class, id);
        empForUpdate.setFirstName(employee.getFirstName());
        empForUpdate.setLastName(employee.getLastName());
        empForUpdate.setGender(employee.getGender());
        empForUpdate.setAge(employee.getAge());
        entityManager.merge(empForUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = EntityUtil.createEntityManager();
        Employee empForDelete = entityManager.find(Employee.class, employee.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(empForDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
