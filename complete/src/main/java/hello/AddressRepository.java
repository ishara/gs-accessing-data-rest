package hello;

//@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressRepository extends CGPagingAndSortingRepository<Address, Long>
{
//    List<Person> findByLastName( @Param("name") String name );
}
