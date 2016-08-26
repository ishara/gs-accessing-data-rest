package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/26/2016 3:06 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/persons",produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonController extends AbstractController
{
    private final PersonRepository personRepository;
    private final PersonXRepository personXRepository;
    private final PersonResourceAssembler personResourceAssembler;

    @Autowired
    public PersonController( PersonRepository personRepository, PersonXRepository personXRepository, PersonResourceAssembler personResourceAssembler )
    {
        this.personRepository = personRepository;
        this.personXRepository = personXRepository;
        this.personResourceAssembler = personResourceAssembler;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{personId}")
    public ResponseEntity<Resource<IPerson>> getPerson( @PathVariable long personId )
    {
        IPerson person = personRepository.findOne( personId );
        if( person == null )
        {
            throw new NoSuchElementException( "Product with id " + personId + " does not exist" );
        }
        return new ResponseEntity<Resource<IPerson>>( personResourceAssembler.toResource( person ),HttpStatus.OK );
    }
    @RequestMapping(method = RequestMethod.GET, value = "x/{personId}")
    public ResponseEntity<Resource<IPerson>> getPersonX( @PathVariable long personId )
    {
        IPerson person = personXRepository.findOne( personId );
        if( person == null )
        {
            throw new NoSuchElementException( "Product with id " + personId + " does not exist" );
        }
        return new ResponseEntity<Resource<IPerson>>( personResourceAssembler.toResource( person ),HttpStatus.OK );
    }
}
