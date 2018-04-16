package cz.tul.data;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class StateDao {
    private SessionFactory sessionFactory;

    /*public StateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
*/
    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void create(State state) {
        session().save(state);
    }

    public boolean exists(String stateName) {
        Criteria crit = session().createCriteria(State.class);
        crit.add(Restrictions.idEq(stateName));
        State state = (State) crit.uniqueResult();
        return state != null;
    }

    @SuppressWarnings("unchecked")
    public List<State> getAllStates() {
//        return session().createQuery("from state").list();
        return session().createCriteria(State.class).list();
    }

    public State getState(String stateName) {
        Criteria crit = session().createCriteria(State.class);

        crit.createAlias("state", "s");

        crit.add(Restrictions.eq("s.StateName", stateName));

        return (State) crit.uniqueResult();
    }

    public boolean delete(String stateName) {
        Query query = session().createQuery("delete from state where StateName=:stateName");
        query.setString("StateName", stateName);
        return query.executeUpdate() == 1;
    }



    public void deleteStates() {
        session().createQuery("delete from state").executeUpdate();
    }

}
