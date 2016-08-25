package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 5:26 PM
 */

import org.hibernate.validator.internal.util.CollectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class SpringStartedListener implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    private static final Logger log = LoggerFactory.getLogger( SpringStartedListener.class );

    @Override public void onApplicationEvent( ContextRefreshedEvent contextStartedEvent )
    {
        Person person = new Person();
        person.setFirstName( "is" );
        person.setLastName( "isl" );
        person.setAge( 10 );
        personRepository.save( person );
        Address address = new Address();
        address.setCity( "Kandy" );
        address.setPerson( person );
        List<Address> addresses = new ArrayList<>(  );
        addresses.add( address );
        addressRepository.save( addresses );
        person.setAddresses( addresses );
        personRepository.save( person );
    }
}