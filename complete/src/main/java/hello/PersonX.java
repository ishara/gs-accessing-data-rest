package hello;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
//@NamedEntityGraph(name = "Person.addresses",
//        attributeNodes = @NamedAttributeNode("addresses"))
//@NamedEntityGraph(name = "accountGraph", attributeNodes = {
//        @NamedAttributeNode("id")})
@Table(name = "PERSON" )
public class PersonX implements Serializable, IPerson
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private int age;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    @OneToMany( mappedBy = "person", fetch = FetchType.LAZY)
    private List<Address> addresses;

//    @JoinColumn(name = "id")
//    @OneToMany(orphanRemoval = true,fetch = FetchType.LAZY)
//    @OneToMany(orphanRemoval = true)

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses( List<Address> addresses )
    {
        this.addresses = (List<Address>) addresses;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge( int age )
    {
        this.age = age;
    }
}
