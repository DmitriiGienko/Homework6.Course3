package Dao;

import pojo.City;
import pojo.Employee;

import java.util.List;

public interface CityDao {

    //    Создание (добавление) сущности City в таблицу.
    void addCity(City city);

    //    Получение списка всех объектов City из базы.
    List<City> getAllCities();

    //    Изменение конкретного объекта City в базе по id.
    void updateCity(int id, City city);

    //    Удаление конкретного объекта City .
    void deleteCity(City city);

    // выбор города по id
    City getCityById(int id);


}
