package co.develhope.API.Custom.Queries1.repositories;

import co.develhope.API.Custom.Queries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {


}
