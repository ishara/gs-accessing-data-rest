package hello;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepository extends CGPagingAndSortingRepository<Address, Long>
{
//    List<Person> findByLastName( @Param("name") String name );
}
