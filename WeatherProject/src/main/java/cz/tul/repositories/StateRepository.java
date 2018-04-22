package cz.tul.repositories;

import cz.tul.data.State;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StateRepository extends CrudRepository<State, String> {

    @Query("select o from State as o where state.statename=:StateName")
    public List<State> findByUsername(@Param("statename") String statename);
}