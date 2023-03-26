package co.develhope.NO_SQL_ORM_esercizio.repositories;

import co.develhope.NO_SQL_ORM_esercizio.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String > {
}
