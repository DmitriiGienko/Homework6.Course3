package DaoImpl;

import Dao.CityDao;
import pojo.City;
import pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class CityDaoImpl implements CityDao {

    @Override
    public void addCity(City city) {
        EntityManager entityManager = EntityUtil.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(city);
        List<Employee> employees = city.getAllEmployees()
                .stream()
                .peek(employee -> employee.setCity(city))
                .peek(entityManager::persist)
                .collect(Collectors.toList());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<City> getAllCities() {
        EntityManager entityManager = EntityUtil.createEntityManager();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM City e";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> cityList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return cityList;
    }

    @Override
    public void updateCity(int id, City city) {
        EntityManager entityManager = EntityUtil.createEntityManager();
        City cityForUpdate = entityManager.find(City.class, city.getCityId());
        cityForUpdate.setCityName(city.getCityName());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = EntityUtil.createEntityManager();
        entityManager.getTransaction().begin();
        City cityID = entityManager.find(City.class, city.getCityId());
        entityManager.remove(cityID);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public City getCityById(int id) {
        EntityManager entityManager = EntityUtil.createEntityManager();
        entityManager.getTransaction().begin();
        City city = entityManager.find(City.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }
}
