package ay.springframework.fruitwebfluxapi.repositories;

import ay.springframework.fruitwebfluxapi.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aliyussef on 22/03/2021
 */
@Repository
public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
