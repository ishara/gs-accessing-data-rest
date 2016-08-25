package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 2:37 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CustomController
{
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonRepositoryService personRepositoryService;
    public CustomController(  )
    {

    }
    @RequestMapping("x2")
    public ResponseEntity<IPerson> getPersonsX2()
    {
       return new ResponseEntity<IPerson>( personRepositoryService.getIPerson( 1 ),HttpStatus.ACCEPTED);
    }
    @RequestMapping("x1")
    public ResponseEntity<List<IPerson>> getPersons()
    {
        Iterable<Person> ts = personRepository.findAll();
        Iterator iterator = ts.iterator();
        List<IPerson> iPersons = new ArrayList<>();
        while( iterator.hasNext() )
        {
            Person next = (Person) iterator.next();
            iPersons.add( next );
        }
        return new ResponseEntity<List<IPerson>>( iPersons, HttpStatus.ACCEPTED );
    }
}
