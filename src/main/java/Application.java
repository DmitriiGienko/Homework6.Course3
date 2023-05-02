import DaoImpl.CityDaoImpl;
import DaoImpl.EmployeeDaoImpl;
import pojo.City;
import pojo.Employee;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        CityDaoImpl cityDao = new CityDaoImpl();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

// создал список сотрудников
        List<Employee> employeeList = List.of(
                new Employee("Дмитрий", "Гиенко", "муж", 39),
                new Employee("Алена", "Кулемина", "жен", 23),
                new Employee("Екатерина", "Хрюшкина", "жен", 17)
        );

// создал город
        cityDao.addCity(new City("Санкт-Петербург", employeeList));

//         Вывел данные по всем сотрудникам (все на месте))
        for (Employee employee : employeeDao.getAllEmployee()) {
            System.out.println(employee);
        }

// изменил сотрудника и посмотрел изменения в таблице
        employeeDao.updateEmployee(3, new Employee("Валерий", "Вильгельмс", "муж", 41));

        for (Employee employee : employeeDao.getAllEmployee()) {
            System.out.println(employee);
        }

// удалил город и убедился что сотрудники тоже удалены
        cityDao.deleteCity(cityDao.getCityById(1));

        for (Employee employee : employeeDao.getAllEmployee()) {
            System.out.println(employee);
        }



    }
}
