package Dao;

import pojo.Employee;
import java.util.List;

public interface EmployeeDao {

    //    Создание (добавление) сущности Employee в таблицу.
    void addEmployee(Employee employee);

    //    Получение конкретного объекта Employee по id.
    Employee getEmployeeById(int id);

    //    Получение списка всех объектов Employee из базы.
    List<Employee> getAllEmployee();

    //    Изменение конкретного объекта Employee в базе по id.
    void updateEmployee(int id, Employee employee);

    //    Удаление конкретного объекта Employee в базе по id.
    void deleteEmployee(Employee employee);
}
