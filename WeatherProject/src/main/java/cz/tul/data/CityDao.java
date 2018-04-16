package cz.tul.data;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;
@Transactional
public class CityDao {



        private SessionFactory sessionFactory;

       /* public CityDao(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
*/
        public Session session() {
            return sessionFactory.getCurrentSession();
        }

        public void create(City city) {
            session().save(city);
        }

        public boolean exists(String cityName) {
            Criteria crit = session().createCriteria(City.class);
            crit.add(Restrictions.idEq(cityName));
            City city = (City) crit.uniqueResult();
            return city != null;
        }
    public City getCity(String cityName) {
        Criteria crit = session().createCriteria(City.class);

        crit.createAlias("city", "c");

        crit.add(Restrictions.eq("c.CityName", cityName));

        return (City) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<City> getStateCities(String stateName) {
        Criteria crit = session().createCriteria(City.class);
        crit.createAlias("city", "c");
        crit.add(Restrictions.eq("city.StateName", stateName));
        return crit.list();
    }

        @SuppressWarnings("unchecked")
        public List<City> getAllCities() {
//        return session().createQuery("from city").list();
            return session().createCriteria(City.class).list();
        }

    public void saveOrUpdate(City city) {
        session().saveOrUpdate(city);
    }

    public boolean delete(String cityName) {
        Query query = session().createQuery("delete from city where CityName=:cityName");
        query.setString("cityName", cityName);
        return query.executeUpdate() == 1;
    }
        public void deleteCities() {
            session().createQuery("delete from city").executeUpdate();
        }

    }
