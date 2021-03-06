package hello;

import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CGPagingAndSortingRepository<Person, Long>
{
//    @EntityGraph(attributePaths = { "addresses" },type = EntityGraph.EntityGraphType.FETCH)

    //        @EntityGraph(value = "Person.addresses", type = EntityGraph.EntityGraphType.FETCH)
    //    @Query(value = "SELECT p FROM Person p where p.id = :id")
//    @Query(value = "SELECT * FROM Person WHERE id = ?1", nativeQuery = true)
//    @EntityGraph("accountGraph")
//    @Transactional
//    @Fetch( value = FetchMode.SUBSELECT)
    Person getById( @Param("id") Long id );

    List<Person> findByLastName( @Param("name") String name );
}
