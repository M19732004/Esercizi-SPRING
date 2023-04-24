package co.develhope.Unit_Test_1.repositories;

import co.develhope.Unit_Test_1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
