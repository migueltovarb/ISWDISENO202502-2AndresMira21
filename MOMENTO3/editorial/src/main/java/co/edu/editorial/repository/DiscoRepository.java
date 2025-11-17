package co.edu.editorial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.editorial.modelo.Disco;

public interface DiscoRepository extends MongoRepository<Disco, ObjectId> {

}
