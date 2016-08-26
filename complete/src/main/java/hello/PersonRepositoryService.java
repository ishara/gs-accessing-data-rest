package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/25/2016 12:38 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonRepositoryService
{
    @Autowired
    PersonRepository personRepository;

//    @Transactional
    public IPerson getIPerson( long id )
    {
        return personRepository.findOne( id );
    }
}
