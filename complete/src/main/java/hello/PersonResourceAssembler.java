package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/26/2016 3:04 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Component
public class PersonResourceAssembler implements ResourceAssembler<IPerson,Resource<IPerson>>
{
    private final ProjectionFactory projectionFactory;

    @Autowired
    public PersonResourceAssembler( ProjectionFactory projectionFactory )
    {
        this.projectionFactory = projectionFactory;
    }

    @Override public Resource<IPerson> toResource( IPerson entity )
    {
        IPerson iPerson = projectionFactory.createProjection( IPerson.class, entity );
        Resource<IPerson> resource = new Resource<>( iPerson );
//        Resource<IPerson> resource = new Resource<>( entity );
        resource.add( linkTo( methodOn( PersonController.class ).getPerson( iPerson.getId() ) ).withSelfRel() );
        return resource;
    }
}
