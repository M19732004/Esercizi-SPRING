package co.develhope.CRUD_esercizio.repositories;

import co.develhope.CRUD_esercizio.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
