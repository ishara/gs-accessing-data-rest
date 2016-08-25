package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 11:55 AM
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

import java.util.ArrayList;
import java.util.List;

public class AuthorityFilter extends SimpleBeanPropertyFilter
{
    RestrictedClassFieldsRepository fieldsRepository;

    public AuthorityFilter()
    {
        //todo this should set with ThreadLocal and move to common module to reuse;
        fieldsRepository = new RestrictedClassFieldsRepository();
    }

    @Override public void serializeAsField( Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer ) throws Exception
    {
        if( include( writer ) )
        {
            List<String> ignoreFields = fieldsRepository.getRestrictedFieldMap().get( pojo.getClass().getName() );
            if( ignoreFields == null )
            {
                List<String> ignoreFieldsFromInterface = null;
                Class<?>[] classes = pojo.getClass().getInterfaces();
                for( Class<?> aClass : classes )
                {
                    List<String> fields = fieldsRepository.getRestrictedFieldMap().get( aClass.getName() );
                    if( fields != null )
                    {
                        ignoreFieldsFromInterface = new ArrayList<>();
                        ignoreFieldsFromInterface.addAll( fields );
                    }
                }
                ignoreFields = ignoreFieldsFromInterface;
            }
            if( ! (ignoreFields != null && ignoreFields.contains( writer.getName() ) ) )
            {
                writer.serializeAsField( pojo, jgen, provider );
            }
        }
        else if( !jgen.canOmitFields() )
        { // since 2.3
            writer.serializeAsOmittedField( pojo, jgen, provider );
        }
    }

    @Override protected boolean include( BeanPropertyWriter writer )
    {
        return true;
    }

    @Override protected boolean include( PropertyWriter writer )
    {
        return true;
    }
}
